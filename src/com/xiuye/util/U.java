package com.xiuye.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.xiuye.bean.Mat;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class U {

	private static final ExecutorService pool = Executors.newFixedThreadPool(10);

	public static void threadStart(Runnable r) {
		pool.execute(r);
	}

	public static void shutdownThreadPool() {
		if (!pool.isShutdown()) {
			pool.shutdown();
		}
	}

	public static void runApplication(Class<? extends Application> cls, String... args) {
		Application.launch(cls, args);
		shutdownThreadPool();
	}

	public static <K, V> Map<K, V> map() {
		return new HashMap<K, V>();
	}

	public static int I(double d) {
		return (int) d;
	}

	public static int I(float f) {
		return (int) f;
	}

	public static WritableImage toImage(String url) {
		try {
			return toImage(new FileInputStream(url));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static WritableImage toImage(InputStream is) {
		return toImage(new Image(is));
	}

	public static WritableImage toImage(Image img) {
		return new WritableImage(img.getPixelReader(), U.I(img.getWidth()), U.I(img.getHeight()));
	}

	public static WritableImage toImage(byte[] data) {
		return toImage(toByteArrayInputStream(data));
	}

	public static ByteArrayInputStream toByteArrayInputStream(byte[] data) {
		return new ByteArrayInputStream(data);
	}

	public static WritableImage rect(WritableImage wi, Color c, int x, int y, int width, int height, int borderWidth) {
		PixelWriter pw = wi.getPixelWriter();
		borderWidth = borderWidth - 1;
		int left = Math.max(x - borderWidth, 0);
		int right = Math.min(x + width + borderWidth, (int) wi.getWidth() - 1);
		int top = Math.max(y - borderWidth, 0);
		int bottom = Math.min(y + height + borderWidth, (int) wi.getHeight() - 1);
		for (int i = left; i <= right; i++) {
			for (int j = top; j <= y; j++) {
				pw.setColor(i, j, c);
			}
		}

		for (int i = left; i <= right; i++) {
			for (int j = bottom; j >= Math.min(y + height, wi.getHeight() - 1); j--) {
				pw.setColor(i, j, c);
			}
		}

		for (int i = left; i <= x; i++) {
			for (int j = y; j <= Math.min(y + height, wi.getHeight() - 1); j++) {
				pw.setColor(i, j, c);
			}
		}

		for (int i = right; i >= x + width; i--) {
			for (int j = y; j <= Math.min(y + height, wi.getHeight() - 1); j++) {
				pw.setColor(i, j, c);
			}
		}

		return wi;

	}

	public static WritableImage rect(WritableImage wi, Color c, int x, int y, int width, int height) {

		return rect(wi, c, x, y, width, height, 1);

	}

	public static WritableImage rect(Image img, Color c, int x, int y, int width, int height, int borderWidth) {
		return rect(toImage(img), c, x, y, width, height, borderWidth);
	}

	public static WritableImage rect(Image img, Color c, int x, int y, int width, int height) {
		return rect(toImage(img), c, x, y, width, height, 1);
	}

	public static WritableImage rect(String url, Color c, int x, int y, int width, int height, int borderWidth) {
		return rect(toImage(url), c, x, y, width, height, borderWidth);
	}

	public static WritableImage rect(String url, Color c, int x, int y, int width, int height) {
		return rect(url, c, x, y, width, height, 1);
	}

	public static Mat toMat(String url) {
		Mat mat = new Mat();
		mat.setImg(toImage(url));
		return mat;
	}

	public static Mat toMat(InputStream is) {
		Mat m = new Mat();
		m.setImg(toImage(is));
		return m;
	}

	public static Mat toMat(byte[] data) {
		return toMat(toByteArrayInputStream(data));
	}


	public static Mat rect(Mat m, Color c, int x, int y, int width, int height, int borderWidth) {
		m.setImg(rect(m.getImg(), c, x, y, width, height, borderWidth));
		return m;
	}

	public static Mat rect(Mat m, Color c, int x, int y, int width, int height) {
		m.setImg(rect(m.getImg(), c, x, y, width, height, 1));
		return m;
	}


}
