package com.xiuye.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.xiuye.bean.Mat;
import com.xiuye.bean.MatInfo;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class U {

	public static <K, V> Map<K, V> map() {
		return new HashMap<K, V>();
	}

	public static int I(double d) {
		return (int) d;
	}

	public static int I(float f) {
		return (int) f;
	}

	public static Image toImage(String url) {
		try {
			return new Image(new FileInputStream(url));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Image toImage(InputStream is) {
		return new Image(is);
	}

	public static WritableImage toImage(Image img) {
		return new WritableImage(img.getPixelReader(), U.I(img.getWidth()), U.I(img.getHeight()));
	}

	public static Image toImage(byte[] data) {
		return toImage(toByteArrayInputStream(data));
	}

	public static ByteArrayInputStream toByteArrayInputStream(byte[] data) {
		return new ByteArrayInputStream(data);
	}

	public static Image rect(WritableImage wi, Color c, int x, int y, int width, int height, int borderWidth) {
		PixelWriter pw = wi.getPixelWriter();
		borderWidth = borderWidth - 1;
		int left = Math.max(x - borderWidth, 0);
		int right = Math.min(x + width + borderWidth, (int) wi.getWidth()-1);
		int top = Math.max(y - borderWidth, 0);
		int bottom = Math.min(y + height + borderWidth, (int) wi.getHeight()-1);
		for (int i = left; i <= right; i++) {
			for (int j = top; j <= y; j++) {
				pw.setColor(i, j, c);
			}
		}

		for (int i = left; i <= right; i++) {
			for (int j = bottom; j >= Math.min(y + height, wi.getHeight()-1); j--) {
				pw.setColor(i, j, c);
			}
		}

		for (int i = left; i <= x; i++) {
			for (int j = y; j <= Math.min(y + height, wi.getHeight()-1); j++) {
				pw.setColor(i, j, c);
			}
		}

		for (int i = right; i >= x + width; i--) {
			for (int j = y; j <= Math.min(y + height, wi.getHeight()-1); j++) {
				pw.setColor(i, j, c);
			}
		}

		return wi;

	}

	public static Image rect(WritableImage wi, Color c, int x, int y, int width, int height) {

		return rect(wi, c, x, y, width, height, 1);

	}

	public static Image rect(Image img, Color c, int x, int y, int width, int height, int borderWidth) {
		return rect(toImage(img), c, x, y, width, height, borderWidth);
	}

	public static Image rect(Image img, Color c, int x, int y, int width, int height) {
		return rect(toImage(img), c, x, y, width, height, 1);
	}

	public static Image rect(String url, Color c, int x, int y, int width, int height, int borderWidth) {
		return rect(toImage(url), c, x, y, width, height, borderWidth);
	}

	public static Image rect(String url, Color c, int x, int y, int width, int height) {
		return rect(url, c, x, y, width, height, 1);
	}

	public static Mat read(String url) {
		Mat mat = new Mat();
		mat.setImg(toImage(url));
		return mat;
	}

	public static Mat read(InputStream is) {
		Mat m = new Mat();
		m.setImg(toImage(is));
		return m;
	}

	public static Mat read(byte[] data) {
		return read(toByteArrayInputStream(data));
	}

	public static MatInfo read(String windowName, String url) {

		MatInfo mi = new MatInfo();
		mi.setWindowName(windowName);
		mi.setMat(read(url));

		return mi;
	}

	public static MatInfo read(String windowName, byte[] data) {

		MatInfo mi = new MatInfo();
		mi.setWindowName(windowName);
		mi.setMat(read(data));

		return mi;
	}

	public static Mat rect(Mat m, Color c, int x, int y, int width, int height, int borderWidth) {
		m.setImg(rect(m.getImg(), c, x, y, width, height, borderWidth));
		return m;
	}

	public static Mat rect(Mat m, Color c, int x, int y, int width, int height) {
		m.setImg(rect(m.getImg(), c, x, y, width, height, 1));
		return m;
	}

	public static MatInfo rect(MatInfo m, Color c, int x, int y, int width, int height, int borderWidth) {
		m.setMat(rect(m.getMat(), c, x, y, width, height, borderWidth));
		return m;
	}

	public static MatInfo rect(MatInfo m, Color c, int x, int y, int width, int height) {
		m.setMat(rect(m.getMat(), c, x, y, width, height, 1));
		return m;
	}

	private final static String PREFIX_WINDOW = "window";
	private static int SUFFIX_WINDOW = 1;

	public static String generateWindowName() {
		return PREFIX_WINDOW + SUFFIX_WINDOW++;
	}

}
