package company;

/**
 * Manages information about an emploee of the company
 */
public cclass Employee {
	
	/**
	 * Sex constants
	 */
	static final public int FEMALE = 0;
	static final public int MALE = 1;
	
	/**
	 * Role constants
	 */
	static final public int WORKER = 0;
	static final public int DEPARTMENT_MGR = 1;
	static final public int CEO = 2;
	
	/**
	 * State variables
	 */
	private String[] _name = new String[0];
	
	private int _sex = -1;
	
	private int _role = -1;
	
	private Department _departm = null;
	
	/* Initialize Emploee */
	public Employee(String firstName, String familyName, int sex) {
		_name = new String[2];
		_name[0] = firstName;
		_name[1] = familyName;
		_sex = sex;
		_role = WORKER;		
	}
	
	/* Get formatted full name of the emploee */
	public String getFullName() {
		String fullName = getSex() == Employee.FEMALE ? "Ms." : "Mr.";
		
		for (int i1 = 0; i1 < _name.length; i1++) {
			fullName += " " + _name[i1];
		}
		return fullName;
	}
	
	/* Get initials of the emploee */
	public String getInitials() {
		String initials = "";
		
		for (int i1 = 0; i1 < _name.length; i1++) {
			initials += _name[i1].charAt(0);
		}
		return initials;
	}
	
	/* Get emploee sex (see constants) */
	public int getSex() {
		return _sex;
	}
	
	/* Get emploee role in the company (see constants) */
	public int getRole() {
		return _role;
	}
	
	/* Get emploee deparment (can be null) */
	public Department getDepartment() {
		return _departm;
	}
	
	/* Change first name */
	public void setFirstName(String name) {
		_name[0] = name;
	}
	
	/* Change last name */
	public void setLastName(String name) {
		_name[1] = name;
	}
	
	/* Change name */
	public void setName(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	/* Set emploee role in the company */
	public void setRole(int role) {
		_role = role;
	}
	
	/* Assign employee to a department */
	public void setDepartment(Department departm) {
		if (_departm != null && _role == WORKER) {
			_departm.removeWorker(this);
		}
		_departm = departm;
		if (_departm != null && _role == WORKER) {
			_departm.addWorker(this);
		}
	}
	
	/**
	 * Compare two Emploees
	 */
	public boolean equals(Object obj)
    {
        if (!(obj instanceof Employee) || obj == null)
        {
            return false;
        }
        else 
        {
            return getFullName().equals(((Employee)obj).getFullName());
        }                
    }
}
