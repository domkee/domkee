package com.fer.librosViejos.client.pages.notfound;

import java.util.Map;

import com.fer.t1.client.HistoryManager;

public class NotFoundHistory extends HistoryManager {

	@Override
	public void onHistoryChange(Map<String, String> arg0) {
		draw();
	}

}
