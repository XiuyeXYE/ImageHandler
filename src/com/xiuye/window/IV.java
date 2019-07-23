package com.xiuye.window;


import com.xiuye.bean.Mat;
import com.xiuye.util.U;
import com.xiuye.util.UI;

import javafx.scene.image.Image;

public class IV {

	private static String windowName = "XY Image Show";
	
	public static void windowName(String winNm) {
		windowName = winNm;
	}

	public static void imshow(Image img) {
		ImagesWindow.addImage(windowName, img);
	}
	
	public static void imshow(Mat mat) {
		ImagesWindow.addImage(windowName, mat.getImg());
	}
	
	
	public static void imshow(Mat... mats) {
		for (Mat mat : mats) {
			ImagesWindow.addImage(UI.generateWindowName(), mat.getImg());
		}
	}

	public static void imshow(String... urls) {
		for (String url : urls) {
			ImagesWindow.addImage(url, U.toImage(url));
		}
	}

	public static void imshow(Image... imgs) {
		for (Image img : imgs) {
			ImagesWindow.addImage(UI.generateWindowName(), img);
		}
	}

	public static void waitKey(String...args) {
		U.runApplication(ImagesWindow.class, args);
	}

}
