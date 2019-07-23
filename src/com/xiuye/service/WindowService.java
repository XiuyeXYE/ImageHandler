package com.xiuye.service;

import com.xiuye.window.IV;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class WindowService extends Service<Object>{

	@Override
	protected Task<Object> createTask() {
		return new Task<Object>() {
			@Override
			protected Object call() throws Exception {
				return null;
			}
		};
	}
	
	public static void main(String[] args) {
		IV.waitKey();
		WindowService ws = new WindowService();
		ws.start();
	}

}
