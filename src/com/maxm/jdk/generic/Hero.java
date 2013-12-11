package com.maxm.jdk.generic;

public class Hero extends Resource {

	protected Hero() {
		super();
	}

	protected Hero(long id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + "]";
	}

}
