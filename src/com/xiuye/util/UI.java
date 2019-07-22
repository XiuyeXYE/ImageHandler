package com.xiuye.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Platform;

public class UI {

	public static void threadStart(Runnable r) {
		U.threadStart(()->{
			Platform.runLater(r);
		});
	}
	
}
