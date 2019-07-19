package com.xiuye.window;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Window extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {

		FileChooser fc = new FileChooser();
//		
//		System.out.println(fc.showOpenDialog(primaryStage));
//		System.out.println(fc.showOpenMultipleDialog(primaryStage));
		System.out.println(fc.showSaveDialog(primaryStage));
		primaryStage.show();
		
	}

}
