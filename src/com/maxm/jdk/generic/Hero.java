package com.maxm.jdk.generic;

public class Hero extends Resource {

	protected Hero() {
		super();
	}

	protected Hero(final long id, final String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + "]";
	}

}
