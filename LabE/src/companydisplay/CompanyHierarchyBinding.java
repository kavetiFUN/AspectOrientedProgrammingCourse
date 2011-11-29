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
	 * Simple worker node (always leaf)
	 */
	public cclass WorkerNode extends Node wraps Employee {
		
		/* Get node name to be displayed */
		public String getText() {
			String name = wrappee.getFullName();
			if (textFits(name)) {
				return name;
			}
			else {
				return wrappee.getInitials();
			}
		}
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
	public cclass DepartmentNode extends CompositeNode wraps Department {
		
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
		
		/* Get child node at given index */
		public Node getChildAt(int i1) {
			return WorkerNode(wrappee.getWorkerAt(i1));			
		}
		
		/* Get the number of children nodes */
		public int getChildCount() { 
			return wrappee.getWorkerCount(); 
		}		
	}
	
	/**
	 * Observe changes in company model
	 */
	
	/* observe employee name change */
	after(Employee e) : execution(* Employee+.set*Name(..)) && this(e) {
		switch (e.getRole()) {
			case Employee.DEPARTMENT_MGR:
				DepartmentNode(e.getDepartment()).textChanged();
				break;
			case Employee.CEO:
				CompanyNode(_company).textChanged();
				break;
			/* fill in */
		}
		System.out.println("employee name changed");
	}
	
	/* observe department children change */
	/* fill in */
	
	/* observe company children change */
	after(Company c) : (execution(* Company+.add*(..)) || 
						execution(* Company+.remove*(..))) && this(c) {
		CompanyNode(c).childrenChanged();
		System.out.println("company children changed");
	}
		
	/* refresh hierarchy display after a top level change */
	pointcut structureChange() : execution(* company.*.*(..)) && !execution(* get*(..));
	
	after() : structureChange() && !cflowbelow(structureChange()) {
		refresh();
		System.out.println("hierarchy display refreshed");
	}	
}