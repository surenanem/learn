/**
 * 
 */
package com.chennaisoft.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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

	@Before("allMethodsInModel()")
	public void loggingAdvice2() {
		log.debug("Advice run. all methods in model...");
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

	@Pointcut("within(org.chennaisoft.model..*)")
	public void allMethodsInModel() {
	}
	@Around("allMethodsInModel()")
	public void aroundAdvice(ProceedingJoinPoint point) throws Throwable {
		long start = System.currentTimeMillis();
		point.proceed();
		long end = System.currentTimeMillis();
		
		System.out.println(point.getThis() + "time taken for this method..."+ (end-start));
		
		
	}

}
