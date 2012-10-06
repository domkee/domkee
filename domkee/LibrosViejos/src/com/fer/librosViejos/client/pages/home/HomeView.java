package com.fer.librosViejos.client.pages.home;

import com.fer.librosViejos.client.widget.NavBar;
import com.fer.t1.client.View;
import com.google.gwt.user.client.ui.FlowPanel;

public class HomeView extends View<HomeHandler> {
	
	private FlowPanel flowPanel;
	private HomeUI homeUI;

	public HomeView() {
		
		flowPanel = new FlowPanel();
		initWidget(flowPanel);
		
		NavBar navBar = new NavBar();
		flowPanel.add(navBar);
		
		homeUI = new HomeUI();
		flowPanel.add(homeUI);
	}



}
