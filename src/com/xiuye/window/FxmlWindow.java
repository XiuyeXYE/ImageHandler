package com.xiuye.window;

import java.net.URL;
import java.util.Map;
import java.util.Objects;

import com.xiuye.util.U;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Map<String, String> mp = this.getParameters().getNamed();
		String title = mp.get("title");
		if (Objects.nonNull(title)) {
			primaryStage.setTitle(title);
		}
		String path = mp.get("fxml");
		if (Objects.nonNull(path)) {
			Parent root = FXMLLoader.load(new URL(path));
			primaryStage.setScene(new Scene(root));
		}
		primaryStage.show();

	}

	public static void running(String title, URL fxml) {
		U.runApplication(FxmlWindow.class, "--title=" + title, "--fxml=" + FxmlWindow.class.getResource("app.fxml"));
	}

	public static void running(URL fxml) {
		U.runApplication(FxmlWindow.class, "--fxml=" + FxmlWindow.class.getResource("app.fxml"));
	}

//	public static void main(String[] args) {
//		U.runApplication(Window.class, "--title=DDDDD","--fxml="+Window.class.getResource("app.fxml"));
//		U.runApplication(Window.class);
//		running(null, Window.class.getResource("app.fxml"));
//		running(Window.class.getResource("app.fxml"));
//	}

}
