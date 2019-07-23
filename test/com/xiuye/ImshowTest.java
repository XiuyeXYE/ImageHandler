package com.xiuye;

import com.xiuye.util.U;
import com.xiuye.window.IV;

import javafx.scene.paint.Color;

public class ImshowTest {

	public static void main(String[] args) {
		
		IV.windowName("Super Man");;
		IV.imshow(U.rect(U.toImage(U.toImage("pic/I1.jpg")),Color.RED,100,100,100,100,10));
		IV.imshow("pic/I1.jpg","pic/I2.jpg");
//		MatInfo mi = U.read("APPTEST", "pic/I1.jpg");
//		U.rect(mi, Color.RED, 100, 100, 200, 200,2);
//		IV.imshow(mi);
		IV.waitKey();
		
	}

}
