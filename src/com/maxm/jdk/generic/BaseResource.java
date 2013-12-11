package com.maxm.jdk.generic;

import com.maxm.jdk.util.PrintUtil;
import com.maxm.jdk.util.TimeUtil;

public class BaseResource {
	protected long destroyTime;

	protected void destroy() {
		destroyTime = TimeUtil.now();
		PrintUtil.println();
		PrintUtil.println("destroied by BaseResource at " + destroyTime);
	}

	public long getDestroyTime() {
		return destroyTime;
	}

	public void setDestroyTime(long destroyTime) {
		this.destroyTime = destroyTime;
	}
}
