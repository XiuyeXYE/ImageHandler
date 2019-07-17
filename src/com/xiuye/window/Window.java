package com.xiuye.window;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Window extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println(this.getParameters().getRaw());
		System.out.println(this.getParameters().getNamed());
		System.out.println(this.getParameters().getUnnamed());
		
		
//		Image image = new Image(new FileInputStream("pic/blueWomanFace.jpg"));
		Image image = new Image(new FileInputStream("pic/I1.jpg"));
		
//		PixelReader pr = image.getPixelReader();
//		WritableImage wi = new WritableImage(pr,(int)image.getWidth(),(int)image.getHeight());
		
//		PixelWriter pw = wi.getPixelWriter();
		
//		
//		for(int i=0;i<100;i++) {
//			pw.setColor(i+10, 10, Color.BLUE);
//			pw.setColor(i+10, 11, Color.RED);
//			pw.setColor(i+10, 12, Color.BLUE);
//		}
//		
//		ImageView iv = new ImageView(wi);
		
		
//		Platform.runLater(()->{
//			Stage s = new Stage();
//			s.show();
//		});
//		FlowPane root = new FlowPane();
		ScrollPane root = new ScrollPane();
		Canvas c = new Canvas(image.getWidth(), image.getHeight());
//		root.getChildren().add(iv);
		root.setContent(c);
		
		GraphicsContext gc = c.getGraphicsContext2D();
		gc.drawImage(image, 0, 0);
		gc.setFont(Font.font(20));
		gc.fillText("HELLO WOLDAdf 是的法师法师！！！", 100, 100);
		WritableImage wi = new WritableImage((int)c.getWidth(), (int)c.getHeight());
		wi = c.snapshot(new SnapshotParameters(),wi );
		Stage s = new Stage();
		s.setScene(new Scene(new ScrollPane(new ImageView(wi))));
		s.setTitle("copied");
		s.show();
		Scene scene = new Scene(root);
		// 给舞台设置场景
		primaryStage.setScene(scene);
		primaryStage.setTitle("Demo");

		primaryStage.show();
//		primaryStage.setResizable(false);
	}

}
