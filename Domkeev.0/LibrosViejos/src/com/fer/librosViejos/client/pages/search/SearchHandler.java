package com.fer.librosViejos.client.pages.search;

import com.fer.t1.client.EventHandler;

public interface SearchHandler extends EventHandler {

	void onSearch(String value);

	void doSearch(String query);

}
