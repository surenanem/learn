/**
 * 
 */
package com.chennaisoft.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author surendra
 *
 */


@Aspect
public class LoggingAspect {
	
	private static Logger log = Logger.getLogger(LoggingAspect.class);

	@Before("execution(public String getName())")
	public void loggingAdvice() {
		//System.out.println("Advice run. Get Method Called...");
		log.debug("Advice run. Get Method Called...");
	}

}
