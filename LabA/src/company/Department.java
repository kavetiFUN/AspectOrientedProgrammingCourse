package company;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Maintains information about a department
 */
public class Department {
	
	/* State variables */
	private String _name;

	private Employee _manager = null;
	
	private LinkedList _workers = new LinkedList();
	
	/* Initialize department */
	public Department(String name) {
		_name = name;
	}
	
	/* Get department name */
	public String getName() {
		return _name;
	}
	
	/* Set department name */
	public void setName(String name) {
		_name = name;
	}
	
	/**
	 * Get department worker at given index 
	 * (Manager is also a worker of the department) 
	 */
	public Employee getWorkerAt(int i1) {
		return (Employee)_workers.get(i1);
	}
	
	/* Get the number of workers at the department */
	public int getWorkerCount() {
		return _workers.size();
	}
	
	/* Get department manager */
	public Employee getManager() {
		return _manager;
	}
	
	/* Register emploee as a worker of the department */
	public void addWorker(Employee empl) {
		_workers.add(empl);		
	}
	
	/* Unregister emploee from the department */
	public void removeWorker(Employee empl) {
		_workers.remove(empl);
	}
	
	/* Appoint the manager of the department */
	public void setManager(Employee empl) {
		_manager = empl;
		_manager.setRole(Employee.DEPARTMENT_MGR);
		_manager.setDepartment(this);
	}
	
	public String toString() {
		return "Department " + _name;
	}
}
