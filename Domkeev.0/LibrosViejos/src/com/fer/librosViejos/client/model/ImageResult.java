package com.fer.librosViejos.client.model;

import java.io.Serializable;

public class ImageResult implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6392743016293205534L;
	
	private String url;
	private int pixelWidth;
	private int pixelHeight;
	
	public ImageResult() {}

	
	public ImageResult init(String url, int pixelWidth, int pixelHeight) {
		this.url = url;
		this.pixelWidth = pixelWidth;
		this.pixelHeight = pixelHeight;
		return this;
	}



	public String getUrl() {
		return url;
	}

	public int getPixelWidth() {
		return pixelWidth;
	}

	public int getPixelHeight() {
		return pixelHeight;
	};
	
	
}
