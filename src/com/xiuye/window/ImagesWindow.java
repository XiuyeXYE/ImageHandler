package com.xiuye.window;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import com.xiuye.bean.Mat;
import com.xiuye.util.U;
import com.xiuye.util.UI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ImagesWindow extends Application {

	private static Map<String, Image> images = Collections.synchronizedMap(U.map());

	private static Map<String, Stage> windows = Collections.synchronizedMap(U.map());

	public static void addImage(String name, Image image) {
		images.put(name, image);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
//		System.out.println(images.size());
		EventHandler<KeyEvent> eh = (e) -> {
			if (e.getCode() == KeyCode.ESCAPE) {
//					window.close();
				Platform.runLater(() -> {
					if (Platform.isFxApplicationThread())
						Platform.exit();
//						not ok
//						try {
//							this.stop();
//						} catch (Exception ex) {
//							ex.printStackTrace();
//						}
				});
			}
		};
		if (images.isEmpty()) {
			BorderPane bp = new BorderPane(new Text("NONE"));
			primaryStage.setScene(new Scene(bp));
			primaryStage.setWidth(500);
			primaryStage.setHeight(500);
			primaryStage.setTitle("NONE");
			primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, eh);
			primaryStage.show();
		}
		for (Entry<String, Image> en : images.entrySet()) {
			String name = en.getKey();
			Image img = en.getValue();
			UI.threadStart(() -> {
				ImageView iv = new ImageView(img);
//					FlowPane pane = new FlowPane(iv);
				ScrollPane pane = new ScrollPane(iv);
				Scene scene = new Scene(pane);
				Stage window = new Stage();
				window.setTitle(name);
				window.setScene(scene);
				window.addEventHandler(KeyEvent.KEY_PRESSED, eh);
				window.show();
				windows.put(name, window);
			});
		}
	}

	public static void addImage(String windowName, Mat mat) {
		addImage(windowName, mat.getImg());
	}

}
