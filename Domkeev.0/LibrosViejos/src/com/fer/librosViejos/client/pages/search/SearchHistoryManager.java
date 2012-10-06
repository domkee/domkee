package com.fer.librosViejos.client.pages.search;

import java.util.Map;

import com.fer.t1.client.HistoryManager;

public class SearchHistoryManager extends HistoryManager {

	@Override
	public void onHistoryChange(Map<String, String> params) {
		
		String query = params.get("q");
		getHandler().doSearch(query);
		draw();
	}

	private SearchHandler getHandler()
	{
		return (SearchHandler)handler;
	}
}
