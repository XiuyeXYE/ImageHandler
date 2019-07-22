package com.xiuye;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

public class TestObjectProperty {

	public static void main(String[] args) {
		SimpleObjectProperty<Image> sop = new SimpleObjectProperty<>();
		System.out.println(sop.get());
	}
	
}
