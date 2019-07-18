package com.xiuye.window;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import com.xiuye.bean.Mat;
import com.xiuye.util.U;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class APP extends Application {

	private static Map<String, Image> images = Collections.synchronizedMap(U.map());

	private static Map<String, Stage> windows = Collections.synchronizedMap(U.map());

	public static void addImage(String name, Image image) {
		images.put(name, image);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
//		System.out.println(images.size());
		for (Entry<String, Image> en : images.entrySet()) {
			String name = en.getKey();
			Image img = en.getValue();
			new Thread(() -> {
				Platform.runLater(() -> {
					ImageView iv = new ImageView(img);
//					FlowPane pane = new FlowPane(iv);
					ScrollPane pane = new ScrollPane(iv);
					Scene scene = new Scene(pane);
					Stage window = new Stage();
					window.setTitle(name);
					window.setScene(scene);
//					window.setResizable(false);
					window.show();
					window.addEventHandler(KeyEvent.KEY_PRESSED, (e) -> {
						if (e.getCode() == KeyCode.ESCAPE) {
//							window.close();
							Platform.runLater(() -> {
								if (Platform.isFxApplicationThread())
									Platform.exit();
//								not ok
//								try {
//									this.stop();
//								} catch (Exception ex) {
//									ex.printStackTrace();
//								}
							});
						}
					});
					windows.put(name, window);
				});
			}).start();
		}
	}

	public static void addImage(String windowName, Mat mat) {
		addImage(windowName, mat.getImg());
	}

}
