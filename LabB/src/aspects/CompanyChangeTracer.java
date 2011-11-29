package aspects;

import java.io.PrintStream;

import company.*;
import util.Tracer;

/**
 * Traces changes in the company model
 */
public cclass CompanyChangeTracer extends Tracer {
	
	public CompanyChangeTracer(PrintStream stream) {
		super(stream);
	}
	
	pointcut tracePoints() :
		   execution(void company.*.set*(..))
		|| execution(void company.*.add*(..))
		|| execution(void company.*.remove*(..))
		|| execution(void Company.transferTo(..));	
}
