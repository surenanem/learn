/**
 * 
 */
package com.chennaisoft.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author surendra
 * 
 */

@Aspect
public class LoggingAspect {

	private static Logger log = Logger.getLogger(LoggingAspect.class);

	@Before("forCircleMethods()")
	public void loggingAdvice1() {
		log.debug("Advice run. Get Method Called...");
	}

	@Before("allCircleMethods()")
	public void loggingAdvice2() {
		log.debug("Advice run. allCircleMethods...");
	}

	// @Before("allGetters()")
	public void secondAdvice() {
		log.debug("Second Advice Executed....");
	}

	@Pointcut("execution(* get*())")
	public void allGetters() {
	}

	@Pointcut("execution(* org.chennaisoft.model.Circle.getName())")
	public void forCircleMethods() {
	}

	@Pointcut("within(org.chennaisoft.model.Circle)")
	public void allCircleMethods() {
	}

}
