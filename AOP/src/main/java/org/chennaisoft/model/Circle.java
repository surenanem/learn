package org.chennaisoft.model;

public class Circle {
	private String name;

	public String getName() {
		return getMyName();
	}

	public void setName(String name) {
		this.name = name;
	}

	protected String getMyName() {
		return "surendra";
	}
}
