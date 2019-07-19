package com.xiuye.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UI {
	
	
	private static final ExecutorService pool = Executors.newFixedThreadPool(10);

	public static void threadStart(Runnable r) {
		pool.execute(r);
	}
	
}
