package com.fer.librosViejos.client.pages.crearAnuncio.widget;

import java.util.List;

import com.fer.librosViejos.client.model.ImageResult;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class ImageResultPanel extends Composite{

	private HorizontalPanel panel;
	private String selectedUrl;
	
	public ImageResultPanel(List<ImageResult> images) {
		
		panel = new HorizontalPanel();
		initWidget(panel);
		selectedUrl = null;
		
		for (final ImageResult imageResult : images) {
			Image img = new Image(imageResult.getUrl());
			img.setStyleName("imageNormal");
			panel.add(img);
			img.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					selectedUrl = imageResult.getUrl();
					updateStyles();
				}
			});
		}
	}

	private void updateStyles() {
		for (Widget img : panel) {
			if(img instanceof Image)
			{
				Image temp = (Image)img;
				String url = temp.getUrl();
				if (url.equals(selectedUrl))
				{
					img.setStyleName("imageSelected");
				}
				else
				{
					img.setStyleName("imageNormal");
				}
			}
		}
	}

	public String getSelectedURL() {
		return selectedUrl;
	}
}
