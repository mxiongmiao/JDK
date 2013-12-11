package com.maxm.jdk.generic;

public abstract class Resource extends BaseResource {
	protected long id;
	protected String name;

	protected Resource() {
		super();
	}

	protected Resource(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	protected void destroy() {
		super.destroy();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + "]";
	}

}
