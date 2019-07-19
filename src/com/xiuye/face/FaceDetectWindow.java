package com.xiuye.face;

import java.io.File;

import com.xiuye.util.OpW;
import com.xiuye.util.U;
import com.xiuye.util.UI;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FaceDetectWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button btn = new Button("本地上传");
		ImageView iv = new ImageView();
		SimpleObjectProperty<Image> imgPrty = new SimpleObjectProperty<>();
		iv.imageProperty().bind(imgPrty);
		btn.setOnAction(e -> {
			FileChooser fc = new FileChooser();
			File f = fc.showOpenDialog(primaryStage);
			Image img = OpW.of(f).ifPresent(file -> {
				return file.exists();
			}).ifTrue(() -> {
				return f.canRead();
			}).ifTrue(() -> {
				return U.toImage(f.getAbsolutePath());
			}).get();
			imgPrty.set(img);
//			UI.threadStart(() -> {
//				iv.setImage(img);
//			});

		});

		ToolBar tb = new ToolBar(btn);

		TextArea info = new TextArea();
		
		ScrollPane scrollPaneImg = new ScrollPane(iv); 
//		ScrollPane scrollPaneImg = new ScrollPane(); 
		
		SplitPane sp = new SplitPane();
		sp.getItems().addAll(scrollPaneImg, info);
		sp.setDividerPositions(0.5, 0.5);
		TextArea result = new TextArea();
		BorderPane bp = new BorderPane();
		bp.setTop(tb);
		bp.setBottom(result);
		bp.setCenter(sp);

		Scene scene = new Scene(bp);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
