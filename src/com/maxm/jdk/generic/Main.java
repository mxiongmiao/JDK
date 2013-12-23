package com.maxm.jdk.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.maxm.jdk.util.PrintUtil;

public class Main {

	public void show(final List<? extends Resource> datas) {
		for (final Resource r : datas) {
			PrintUtil.println(r);
		}
	}

	public void destroy(final List<? super Resource> datas) {
		for (final Object obj : datas) {
			final BaseResource b = (BaseResource) obj;
			b.destroy();
		}
	}

	public static void main(final String[] args) {
		final List<Hero> datas = new ArrayList<>();
		final Hero e = new Hero();
		e.setId(new Random().nextLong());
		e.setName("赵云");
		datas.add(e);
		new Main().show(datas);

		final List<BaseResource> baseResources = new ArrayList<>();
		baseResources.add(e);
		new Main().destroy(baseResources);
	}
}
