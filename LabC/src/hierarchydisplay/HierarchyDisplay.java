package hierarchydisplay;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import shapes.*;
import util.TextDraw;

/**
 * Basic hierarchy display implementation. 
 */
public cclass HierarchyDisplay extends IHierarchyDisplay {
	
	/* State variables */
	protected Component view = null;
	protected Node root = null;
	
	/* Get hierarchy root */
	public Node getRoot() {
		return root;
	}
	
	/* Set hierarchy root */
	public void setRoot(Node root) {
		this.root = root;
	}
	
	/* Flag if layout is valid */
	protected boolean validLayout = false; 
		
	/* Refresh display */
	public void refresh() {
		view.repaint();
	}
		
	/* Update hierarchy layout */
	public void calculateLayout() {
		if (getRoot() != null) {
			getRoot().calculateLayout(50, 100, 0, view.getWidth());
		}
		validLayout = true;
	}
	
	/* Draw the hierarchy */
	public void draw(Graphics g) {
		if (!validLayout) {
			calculateLayout();
		}
		if (getRoot() != null) {
			getRoot().draw(g);
		}
	}
	
	/* Set view, where hierarchy is diplayed */
	public void setView(Component view) {
		this.view = view;
	}
	
	/* Get graphics */
	public Graphics getGraphics() {
		return view.getGraphics();
	}
	
	/* invalidate parent layout */
	public void invalidateLayout() {
		validLayout = false;
	}
	
	/** 
	 * Base node
	 */
	public cclass Node {
		
		/* State variables */
		protected Rectangle shape = null;
		protected String text = "no name";
		
		public Node() {
			shape = new Rectangle();
		}
				
		/* get display text */
		public void getText() {
			return text;
		}
		
		/* set display text */
		public void setText(String text) {
			this.text = text;
			textChanged();
		}
		
		/* Get current shape for display */
		public TextShape getShape() {
			return shape;
		}
		
		/* Draw node */
		public void draw(Graphics g) {
			shape.draw(g);			
		}
		
		/* Test if text fits in the shape */
		public boolean textFits(String text) {
			return calcTextWidth(text) < shape.getWidth();
		}
		
		/* Generate node layout */
		public void calculateLayout(int y, int stepY, int leftX, int rightX) {
			positionNode(new Point((rightX + leftX) / 2, y), rightX-leftX-10);
		}
		
		/* update text */
		public void textChanged() {
			shape.setText(getText());
		}
		
		/* Position node at given place */
		protected void positionNode(Point pt, int maxWidth) {
			int width = maxWidth > 150 ? 150 : maxWidth;
			adjustShape(pt, width);
			shape.setText(getText());
		}
		
		/* Adjust shape for given center point and width */
		protected void adjustShape(Point center, int width) {
			shape.setPoints(center.x - width / 2, center.y - 20, center.x + width / 2, center.y + 20);			
		}
		
		/* Calculate text width */
		protected int calcTextWidth(String text) {
			return TextDraw.calcTextWidth(getGraphics(), text) + 10;
		}
		
		/* Calculate the total number of leaves under the node (needed for layout) */
		public int getNumLeaves() {
			return 1;
		}
	}
	
	/**
	 * Node with children
	 */
	public cclass CompositeNode {
		
		/* State variables */
		protected List connections = new LinkedList();
		protected List children = new LinkedList();
		protected boolean validChildren = false; 
		
		/* Get node child at given index */
		public Node getChildAt(int i1) {
			return (Node)children.get(i1);
		}
		
		/* Get the number of node children */
		public int getChildCount() {
			return children.size();
		}
		
		/* Add new child to the node */
		public void addChild(Node child) {
			children.add(child);
			childrenChanged();
		}
				
		/* Draw node, its children and links to the children */
		public void draw(Graphics g) {
			super.draw(g);
			
			/* draw children */
			for (int i1 = 0; i1 < getChildCount(); i1++) {
				getChildAt(i1).draw(g);				
			}
			
			/* draw connections */
			Iterator it = connections.iterator();
			while (it.hasNext()) {
				((Connection)it.next()).draw(g);
			}
		}
		
		/* Generate node layout. Propagates to children */
		public void calculateLayout(int y, int stepY, int leftX, int rightX) {
			super.calculateLayout(y, stepY, leftX, rightX);
			
			int cnt = getChildCount();
			
			/* calculate connections */
			if (!validChildren) {
				connections.clear();
				for (int i1 = 0; i1 < cnt; i1++) {
					connections.add(new Connection(this, getChildAt(i1)));
				}
				validChildren = true;
			}
			
			int cell = (rightX - leftX) / getNumLeaves();
			int pos = 0;
			for (int i1 = 0; i1 < cnt; i1++) {
				int nextPos = pos + getChildAt(i1).getNumLeaves();
				getChildAt(i1).calculateLayout(
						y + stepY, stepY, 
						leftX + cell * pos, 
						leftX + cell * nextPos);
				pos = nextPos;
			}			
		}
		
		/* update children */
		public void childrenChanged() {
			/* mark that chilren are invalid */
			validChildren = false;
			
			/* invalidate hierarchy layout */
			invalidateLayout();
		}
		
		/* Calculate the total number of leaves under the node */
		public int getNumLeaves() {
			int numLeaves = 0;
			for (int i1 = 0; i1 < getChildCount(); i1++) {
				numLeaves += getChildAt(i1).getNumLeaves();				
			}
			return numLeaves == 0 ? 1 : numLeaves;
		}
	}
	
	/**
	 * Connection between nodes
	 */
	public cclass Connection {
		
		protected CompositeNode parent;
		protected Node child;
		protected Connector connShape;
		
		/* initialize connection bewtween given nodes */
		public Connection(CompositeNode parent, Node child) {
			this.parent = parent;
			this.child = child;	
			initShape();
		}
		
		/* draw connection */
		public void draw(Graphics g) {
			connShape.draw(g);
		}
		
		/* initialize connection shape */
		protected void initShape() {
			connShape = new StraightConnector(parent.getShape(), child.getShape());
		}
	}
}
