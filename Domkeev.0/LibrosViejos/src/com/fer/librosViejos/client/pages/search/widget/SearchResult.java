package com.fer.librosViejos.client.pages.search.widget;

import com.fer.librosViejos.client.model.Anuncio;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.NumberLabel;

public class SearchResult extends Composite implements ClickHandler{

	private Anuncio book;
	private HorizontalPanel flowPanel;
	private Label txtName;
	private Label txtOwner;
	private Label txtDescription;
	private Image image;
	private FlowPanel flowPanel_1;
	private NumberLabel<Double> txtPrice;
	
	public SearchResult(Anuncio book) {
		
		flowPanel = new HorizontalPanel();
		initWidget(flowPanel);
		flowPanel.setStyleName("searchResult");
		
		image = new Image("images/libro.png");
		image.setStyleName("searchResultImg");
		flowPanel.add(image);
		image.setWidth("50px");
		flowPanel.setCellWidth(image, "50px");
		
		flowPanel_1 = new FlowPanel();
		flowPanel_1.setStyleName("floatLeft");
		flowPanel.add(flowPanel_1);
		flowPanel_1.setSize("100%", "100%");
		
		txtName = new Label(book.getName());
		txtName.setStyleName("searchResultName");
		flowPanel_1.add(txtName);
		
		txtDescription = new Label(book.getDescription());
		txtDescription.setStyleName("searchResultDescription");
		flowPanel_1.add(txtDescription);
				
		txtPrice = new NumberLabel<Double>();
		txtPrice.setValue(book.getPrice());
		txtPrice.setStyleName("searchResultPrice");
		flowPanel_1.add(txtPrice);
		
		txtOwner = new Label(book.getOwner());
		txtOwner.setStyleName("searchResultOwner");
		flowPanel_1.add(txtOwner);
	}

	@Override
	public void onClick(ClickEvent event) {
		History.newItem("anuncio/id="+book.getId());
	}
}
