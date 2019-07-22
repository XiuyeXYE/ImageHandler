package com.xiuye;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		pool.execute(()->{
			System.out.println("123");
		});
		System.out.println(pool.shutdownNow());
//		pool.execute(()->{
//			System.out.println("567");
//		});
	}
	
}
