package com.xiuye.bean;


import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Mat {

	private WritableImage img;

	public WritableImage getImg() {
		return img;
	}

	public void setImg(WritableImage img) {
		this.img = img;
	}

	public Image readOnlyImg() {
		return this.img;
	}
	
	@Override
	public String toString() {
		return "Mat [img=" + img + "]";
	}

	
	
	
}
