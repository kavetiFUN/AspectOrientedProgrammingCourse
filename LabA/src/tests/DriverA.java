package tests;

import company.Company;
import company.Department;
import company.Employee;

public class DriverA {

	public static Company loadCompany() {
		Company company = new Company();
		
		Employee tom = new Employee("Tom", "T.", Employee.MALE);
		Employee anna = new Employee("Anna", "A.", Employee.FEMALE);
		Employee emily = new Employee("Emily", "R.", Employee.FEMALE);
		Employee paul = new Employee("Paul", "P.", Employee.MALE);
		
		Department production = new Department("Production");
				
		company.addDepartment(production);
		
		tom.setDepartment(production);
		anna.setDepartment(production);			
		paul.setDepartment(production);
		emily.setDepartment(production);
		
		production.setManager(anna);
		
		return company;
	}
	
	public static void changeCompany(Company company) {
		Department controlling = new Department("Management");		
		company.addDepartment(controlling);
		
		Employee marta = new Employee("Marta", "M.", Employee.FEMALE);
		
		marta.setDepartment(controlling);
	}
	
	public static void main(String[] args) {
		// first: load the company model from the database
		System.out.println("*** load company");
		Company company = loadCompany();
			
		System.out.println("\n\n*** change the model");
		
		changeCompany(company);	
	}
}
