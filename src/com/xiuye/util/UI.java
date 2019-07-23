package com.xiuye.util;

import javafx.application.Platform;

public class UI {

	public static void threadStart(Runnable r) {
		U.threadStart(() -> {
			runLater(r);
		});
	}

	public static void runLater(Runnable r) {
		Platform.runLater(r);
	}
	

	private final static String PREFIX_WINDOW = "window";
	private static int SUFFIX_WINDOW = 1;

	public static String generateWindowName() {
		return PREFIX_WINDOW + SUFFIX_WINDOW++;
	}


}
