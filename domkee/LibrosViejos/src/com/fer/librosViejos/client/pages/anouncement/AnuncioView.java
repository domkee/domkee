package com.fer.librosViejos.client.pages.anouncement;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.widget.NavBar;
import com.fer.t1.client.View;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;

public class AnuncioView extends View<AnuncioHandler> implements ClickHandler {
	
	private FlowPanel container;

	public AnuncioView() {
		
		container = new FlowPanel();
		initWidget(container);
						
	}

	@Override
	public void onClick(ClickEvent event) {
	}

	public void draw(Anuncio result) {

		container.clear();
		NavBar navBar = new NavBar();
		container.add(navBar);
		
		container.add(new AnuncioUI(result));	
		
	}

}
