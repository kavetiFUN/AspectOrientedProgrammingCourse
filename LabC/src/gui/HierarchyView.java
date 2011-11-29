package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JComponent;
import hierarchydisplay.IHierarchyDisplay;

/**
 * Application view. Displays a hierarchy
 */
public class HierarchyView extends JComponent {
	
	IHierarchyDisplay _hierarchy = null;
	
	public HierarchyView() {
		addComponentListener(new MyComponentListener());
	}
	
	/* Get currently displayed hierarchy */
	public IHierarchyDisplay getHierarchy() {
		return _hierarchy;
	}
	
	/* Set a hierarchy to be displayed */
	public void setHierarchy(IHierarchyDisplay hier) {
		_hierarchy = hier;
		_hierarchy.setView(this);
		repaint();
	}
	
	/* Paint view area */
	public void paint(Graphics g) {
		
		/* fill background with white color */
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
				
		/* draw hierarchy */
		if (_hierarchy != null) {
			g.setColor(Color.black);
			_hierarchy.draw(g);
		}
	}
	
	/**
	 * Handle component resize event
	 */
	public class MyComponentListener extends ComponentAdapter {
		
		public void componentResized(ComponentEvent e) {
			if (_hierarchy != null) {
				_hierarchy.calculateLayout();
				repaint();
			}
	    }
	}
}
