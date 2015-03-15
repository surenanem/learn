package org.chennaisoft.model;

public class Circle {
	private String name;

	public String getName() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
