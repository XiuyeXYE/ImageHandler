package com.xiuye.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class FxmlController implements Initializable{

	@FXML
	private Button testBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("location= "+location);
		System.out.println("resources= "+resources);
	}

	public void click(ActionEvent event) {
		System.out.println(testBtn);
	}
	
	
}
