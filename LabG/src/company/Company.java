package company;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Maintains top level information about the company structure
 */
public cclass Company {
	
	/**
	 * State variables
	 */
	private Employee _ceo;
	
	private LinkedList _departments = new LinkedList();
	
	/* Get current CEO */
	public Employee getCEO() {
		return _ceo;
	}
	
	/* Get department at given index */
	public Department getDepartmentAt(int i1) {
		return (Department)_departments.get(i1);
	}
	
	/* Get the number of departments in the company */
	public int getDepartmentCount() {
		return _departments.size();
	}
	
	/* Appoint the CEO of the company */
	public void setCEO(Employee empl) {
		_ceo = empl;
		_ceo.setRole(Employee.CEO);
		System.out.println("Welcome new big boss " + _ceo.getFullName() + "!");
	}
	
	/* Add new department */
	public void addDepartment(Department deptm) {
		_departments.add(deptm);
	}
	
	/* Transfer emploee to another position in the company */
	public void transferTo(Employee empl, int role, Department deptm) {
		
		if (empl.getDepartment() != null) {
			empl.setDepartment(null);
		}
		
		switch (role) {
		case Employee.CEO:
			setCEO(empl);
			break;
		
		case Employee.DEPARTMENT_MGR:
			deptm.setManager(empl);
			break;
		
		default:
			empl.setRole(Employee.WORKER);
			empl.setDepartment(deptm);
			break;
		}
	}
}
