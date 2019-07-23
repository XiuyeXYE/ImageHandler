package com.xiuye.window;

import java.util.List;

import com.xiuye.bean.Mat;
import com.xiuye.bean.MatInfo;
import com.xiuye.util.U;

import javafx.application.Application;
import javafx.scene.image.Image;

public class IV {

	public static void imshow(List<MatInfo> mats) {
		imshow(mats.toArray(new MatInfo[mats.size()]));
	}

	public static void imshow(MatInfo... mats) {
		for (MatInfo mi : mats) {
			ImagesWindow.addImage(mi.getWindowName(), mi.getMat());
		}
	}

	public static void imshow(Mat... mats) {
		for (Mat mat : mats) {
			ImagesWindow.addImage(U.generateWindowName(), mat.getImg());
		}
	}

	public static void imshow(String... urls) {
		for (String url : urls) {
			ImagesWindow.addImage(url, U.toImage(url));
		}
	}

	public static void imshow(Image... imgs) {
		for (Image img : imgs) {
			ImagesWindow.addImage(U.generateWindowName(), img);
		}
	}

	public static void waitKey(String...args) {
//		Application.launch(APP.class,args);
		U.runApplication(ImagesWindow.class, args);
	}

}
