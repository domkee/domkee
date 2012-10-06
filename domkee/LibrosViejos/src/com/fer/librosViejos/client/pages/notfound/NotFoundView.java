package com.fer.librosViejos.client.pages.notfound;

import com.fer.librosViejos.client.widget.NavBar;
import com.fer.t1.client.EventHandler;
import com.fer.t1.client.View;
import com.google.gwt.user.client.ui.FlowPanel;

public class NotFoundView extends View<EventHandler> {

	FlowPanel container;
	public NotFoundView() {
		container = new FlowPanel();
		initWidget(container);
		
		container.add(new NavBar());
		container.add(new NotFoundUI());
	}
}
