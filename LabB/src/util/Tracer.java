package util;

import java.io.PrintStream;
import java.util.LinkedList;

import company.*;
import org.caesarj.runtime.*;

/**
 * General tracing aspect
 */
abstract public cclass Tracer {
	
	private PrintStream stream;
	private String indent = "";
	
	public Tracer(PrintStream stream) {
		this.stream = stream;
	}
	
	abstract pointcut tracePoints();
	
	void around(): tracePoints() {
		stream.println(indent + thisJoinPoint.getSignature().toShortString() + " ");
		String oldIndent = indent;
		indent = indent + "  ";
		proceed();
		indent = oldIndent;
	}	
}
