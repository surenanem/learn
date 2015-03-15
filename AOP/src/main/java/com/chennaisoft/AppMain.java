/**
 * 
 */
package com.chennaisoft;

import org.chennaisoft.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author surendra
 * 
 */
public class AppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		
		System.out.println(shapeService.getCircle().getName());
		//System.out.println(shapeService.getTriangle().getName());

	}

}
