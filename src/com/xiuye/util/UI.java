package com.xiuye.util;

import javafx.application.Platform;

public class UI {

	public static void threadStart(Runnable r) {
		U.threadStart(()->{
			Platform.runLater(r);
		});
	}
	
}
