package aspects;

import company.*;


/**
 * Traces changes in the company model
 */
public deployed cclass CompanyChangeTracer {
	
	pointcut change() :
		   execution(void company.*.set*(..))
		|| execution(void company.*.add*(..))
		|| execution(void company.*.remove*(..))
		|| execution(void Company.transferTo(..));
	
	after(Object o): change() && this(o) {
		System.out.println("Object '" + o.toString() + "' changed");
	}
}
