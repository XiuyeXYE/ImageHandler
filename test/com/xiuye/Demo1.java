package com.xiuye;

import java.awt.image.BufferedImage;
import java.util.concurrent.CountDownLatch;

import javax.imageio.ImageIO;

import com.sun.javafx.tk.Toolkit;
import com.xiuye.util.U;
import com.xiuye.window.FxmlWindow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		BufferedImage bi = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
//		ImageIO.write(im, formatName, output);

//		Window w = new Window();
//		w.launch();
//		CountDownLatch latch = new CountDownLatch(1);
//		new Thread(()-> {
//			
//			Platform.runLater(()->{
//				Stage s = new Stage();
//				s.show();
//			});
//			latch.countDown();
//		}).start();

//		latch.await();
		Application.launch(FxmlWindow.class, "ABC", "123456","--KEY=VALUE");
//		Canvas c = new Canvas();
//		c.getGraphicsContext2D();
//		Image i = U.toImage("pic/I1.jpg");
//		WritableImage wi = U.toImage(i);
//		i.getPixelReader();
		
//		Image img = new Image();
//		Canvas c = new Canvas();
//		c.getGraphicsContext2D().drawImage(img, x, y);;
	}

}
