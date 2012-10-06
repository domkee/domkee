package com.fer.librosViejos.client.services.imageSearch;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ImageSearchServiceAsync {

	void searchImages(String query, AsyncCallback<List<com.fer.librosViejos.client.model.ImageResult>> callback);

}
