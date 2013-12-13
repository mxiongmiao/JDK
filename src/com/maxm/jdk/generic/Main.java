package com.maxm.jdk.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.maxm.jdk.util.PrintUtil;

public class Main {

	public void show(List<? extends Resource> datas) {
		for (Resource r : datas) {
			PrintUtil.println(r);
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
		datas.add(e);
		new Main().show(datas);

		List<BaseResource> baseResources = new ArrayList<>();
		baseResources.add(e);
		new Main().destroy(baseResources);
	}
}
