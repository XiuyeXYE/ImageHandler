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

}
