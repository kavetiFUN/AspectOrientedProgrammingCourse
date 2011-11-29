package tests;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Vector;

import aspects.*;

import company.*;

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
		PrintStream initLog = openLogFile();		
		CompanyChangeTracer tracer = new CompanyChangeTracer(System.out);
		CompanyChangeTracer tracerLogFile = new CompanyChangeTracer(openLogFile());
		
		// first: load the company model from the database
		System.out.println("*** load company");
		Company company = loadCompany();
		
		// Deploy tracers after loadCompany()
		deploy tracer;
		deploy tracerLogFile;
		
		// then: activate the company model observer
		System.out.println("\n\n*** change the model");
		
		changeCompany( company );
		
		undeploy tracer;
	}
	
	public static PrintStream openLogFile() {
		try {
			return new PrintStream("init.log");
		}
		catch (FileNotFoundException e) {
			System.out.println("Failed to open init.log");
			return null;
		}
	}
}
