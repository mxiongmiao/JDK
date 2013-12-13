package com.maxm.jdk.generic;

import org.apache.log4j.Logger;

//import com.maxm.jdk.util.PrintUtil;
import com.maxm.jdk.util.TimeUtil;

public class BaseResource {
	private static Logger logger = Logger.getLogger(BaseResource.class);
	
	protected long destroyTime;

	protected void destroy() {
		destroyTime = TimeUtil.now();
		logger.info("destroied by BaseResource at " + destroyTime);
	}

	public long getDestroyTime() {
		return destroyTime;
	}

	public void setDestroyTime(long destroyTime) {
		this.destroyTime = destroyTime;
	}
}
