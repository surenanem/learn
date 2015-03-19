/**
 * 
 */
package com.chennaisoft.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.chennaisoft.intro.UsageTracking;
import org.chennaisoft.intro.UsageTrackingImpl;
import org.springframework.core.annotation.Order;

/**
 * @author surendra
 * 
 */

@Aspect
public class LoggingAspect {

	private static Logger log = Logger.getLogger(LoggingAspect.class);

	@DeclareParents(value = "org.chennaisoft.service.*+", defaultImpl = UsageTrackingImpl.class)
	public static UsageTracking blah;

	public void loggingAdvice2() {
		log.debug("Advice run. all methods in model...order 1");
	}

	@Before("allGetters() && this(usageTracked)")
	public void recordUsage(UsageTracking usageTracked) {
		usageTracked.showUsage();
	}

	@Order(1)
	@Before("forCircleMethods()")
	public void loggingAdvice1() {
		log.debug("Advice run. Get Method Called..order 2.");
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

		System.out.println(point.getThis() + "time taken for this method..." + (end - start));

	}

}
