/*
 * CaesarJ Tutorial
 *
 * 2004. TU-Darmstadt. Software Technology Group 
 */
package server;

import org.caesarj.runtime.rmi.CaesarHost;
import company.*;

/**
 * Company remoting aspect 
 */
public cclass CompanyRemoting {
	
	/**
	 * Export Department objects for remote access
	 */
	after(Department d) : execution (Department+.new(..)) && this(d) {
		CaesarHost.export(d);
		System.out.println("Department " + d.getName() + " exported");
	}
	
	/**
	 * Export Employee objects for remote access
	 */
	after(Employee e) : execution (Employee+.new(..)) && this(e) {
		CaesarHost.export(e);
		System.out.println("Employee " + e.getFullName() + " exported");
	}
}
