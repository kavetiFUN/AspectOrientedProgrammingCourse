package companydisplay;

import java.util.Iterator;
import java.util.Vector;

import company.*;
import hierarchydisplay.IHierarchyDisplay;

/**
 * Binding to display company management hierarchy
 */
abstract public cclass CompanyHierarchyBinding extends IHierarchyDisplay {
	
	/* State variables */
	protected Company _company = null;
	
	/* Set company */
	public void setCompany(Company comp) {
		_company = comp;
	}
	
	/* Get root node of the hierarchy */
	public Node getRoot() {
		return CompanyNode(_company);
	}
	
	/*************************************************************** 
	 * Company CEO node
	 */
	public cclass CompanyNode extends CompositeNode wraps Company {
		
		/* Get node text to be displayed */
		public String getText() {
			String name = wrappee.getCEO().getFullName();
			if (textFits(name + " (CEO)")) {
				return name + " (CEO)";
			}
			else {
				return wrappee.getCEO().getInitials();
			}
		}
		
		/* Get child node at given index */
		public Node getChildAt(int i1) {
			return DepartmentNode(wrappee.getDepartmentAt(i1));			
		}
		
		/* Get the number of children nodes */
		public int getChildCount() { 
			return wrappee.getDepartmentCount();
		}
	}
	
	/*************************************************************** 
	 * Department manager node
	 */
	public cclass DepartmentNode extends Node wraps Department {
		
		/* Get node text to be displayed */
		public String getText() {
			String mgrName = wrappee.getManager().getFullName();
			String deptmName = " (" + wrappee.getName() + ")";
			if (textFits(mgrName + deptmName)) {
				return mgrName + deptmName;
			}
			else {
				return mgrName;
			}
		}
		
		/* fill in */
	}
	
	/* implement WorkerNode */
}