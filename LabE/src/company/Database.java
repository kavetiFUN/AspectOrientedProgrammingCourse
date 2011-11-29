package company;

/**
 * Loads company data
 */
public class Database {
	
	/* Load company data */
	public static void load(Company comp) {
		
		Employee mary = new Employee("Mary", "M.", Employee.FEMALE);
	
		Employee steve = new Employee("Steve", "S.", Employee.MALE);
		Employee robert = new Employee("Robert", "R.", Employee.MALE);
		
		Employee tom = new Employee("Tom", "T.", Employee.MALE);
		Employee anna = new Employee("Anna", "A.", Employee.FEMALE);
		Employee emily = new Employee("Emily", "R.", Employee.FEMALE);
		Employee paul = new Employee("Paul", "P.", Employee.MALE);
		
		Department sales = new Department("Sales");
		Department production = new Department("Production");
		
		comp.setCEO(mary);
		comp.addDepartment(sales);		
		comp.addDepartment(production);
		
		sales.setManager(robert);
		tom.setDepartment(sales);
		anna.setDepartment(sales);
		
		production.setManager(steve);
		paul.setDepartment(production);
		emily.setDepartment(production);
	}
}
