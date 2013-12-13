package com.maxm.jdk.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class);

	public void show(List<? extends Resource> datas) {
		for (Resource r : datas) {
			logger.info(r);
		}
	}

	public void destroy(List<? super Resource> datas) {
		for (Object obj : datas) {
			BaseResource b = (BaseResource) obj;
			b.destroy();
		}
	}

	public static void main(String[] args) {
		List<Hero> datas = new ArrayList<>();
		Hero e = new Hero();
		e.setId(new Random().nextLong());
		e.setName("赵云");
		logger.info(e.getName());
		datas.add(e);
		new Main().show(datas);

		List<BaseResource> baseResources = new ArrayList<>();
		baseResources.add(e);
		new Main().destroy(baseResources);
	}
}
