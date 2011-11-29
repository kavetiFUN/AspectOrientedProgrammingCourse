package guidisplay;

import java.awt.Component;
import java.awt.Container;
import java.util.Iterator;
import java.util.Vector;

import company.*;
import hierarchydisplay.IHierarchyDisplay;

/**
 * Binding to display AWT component hierarchy
 */
abstract public cclass GUIHierarchyBinding extends IHierarchyDisplay {
	
	/* State variables */
	protected Component _component = null;
	
	/* Set root component */
	public void setRootComponent(Component comp) {
		_component = comp;
	}
	
	/* Get root node of the hierarchy */
	public Node getRoot() {
		return wrapComponent(_component);
	}
	
	/*************************************************************** 
	 * AWT Component node
	 */
	public cclass ComponentNode extends Node wraps Component {
		
		/* Get node name to be displayed */
		public String getText() {
			String name = wrappee.getClass().getName();
			if (textFits(name)) {
				return name;
			}
			else {
				return name.substring(name.lastIndexOf('.') + 1);
			}
		}
	}
	
	/*************************************************************** 
	 * AWT Container node
	 */
	public cclass ContainerNode extends CompositeNode wraps Container {
		
		/* Get node name to be displayed */
		public String getText() {
			String name = wrappee.getClass().getName();
			if (textFits(name)) {
				return name;
			}
			else {
				return name.substring(name.lastIndexOf('.') + 1);
			}
		}
		
		/* Get child node at given index */
		public Node getChildAt(int i1) {
			return wrapComponent(wrappee.getComponent(i1));			
		}
		
		/* Get the number of children nodes */
		public int getChildCount() { 
			return wrappee.getComponentCount();
		}
	}
	
	public Node wrapComponent(Component comp) {
		if (comp instanceof Container) {
			return ContainerNode((Container)comp);
		}
		else {
			return ComponentNode(comp);
		}
	}
}