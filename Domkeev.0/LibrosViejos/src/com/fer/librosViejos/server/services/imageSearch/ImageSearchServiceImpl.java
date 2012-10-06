/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fer.librosViejos.server.services.imageSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fer.librosViejos.client.services.imageSearch.ImageSearchService;
import com.fer.simpleBingClient.image.DefaultSimpleBingImages;
import com.fer.simpleBingClient.image.ISimpleBingImages;
import com.fer.simpleBingClient.image.ImageResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ImageSearchServiceImpl extends RemoteServiceServlet implements ImageSearchService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7678788467822072917L;

	private ISimpleBingImages bingSearch;
	
	@Override
	public List<com.fer.librosViejos.client.model.ImageResult> searchImages(String query) throws IOException{
		bingSearch = new DefaultSimpleBingImages();
		List<ImageResult> imageRes = bingSearch.getImageURLs(query, 5);
		ArrayList<com.fer.librosViejos.client.model.ImageResult> result = new ArrayList<com.fer.librosViejos.client.model.ImageResult>();
		
		for (ImageResult img : imageRes) {
			String url = img.getMediaURL();
			int pixelWidth = img.getWidth();
			int pixelHeight = img.getHeight();
			result.add(new com.fer.librosViejos.client.model.ImageResult().init(url, pixelWidth, pixelHeight));
		}
		
		return result;
	}
	
	
	
	
	
	
}
