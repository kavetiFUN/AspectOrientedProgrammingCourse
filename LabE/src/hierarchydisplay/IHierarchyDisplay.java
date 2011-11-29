package hierarchydisplay;

import java.awt.Component;
import java.awt.Graphics;

/**
 * Hierarchy display collaboration interface
 */
abstract public cclass IHierarchyDisplay {
	
	/* get root node */
	abstract public Node getRoot();
	
	/* (re)calculate hiearchy layout */
	abstract public void calculateLayout();
	
	/* draw hierarchy */
	abstract public void draw(Graphics g);
	
	/* set owner component */ 
	abstract public void setView(Component view);
	
	/* Refresh display */
	abstract public void refresh();
		
	/** 
	 * Base node 
	 */
	abstract public cclass Node {
		/* get display text */
		abstract public String getText();
		
		/* Test if text fits in the shape */
		abstract public boolean textFits(String text);
		
		/* update text */
		abstract public void textChanged();
	}
	
	/**
	 *  Composite node 
	 */
	abstract public cclass CompositeNode extends Node {
		
		/* get i-th child */
		abstract public Node getChildAt(int i); 
		
		/* get number of children */
		abstract public int getChildCount(); 
		
		/* update children */
		abstract public void childrenChanged();
	}
}
