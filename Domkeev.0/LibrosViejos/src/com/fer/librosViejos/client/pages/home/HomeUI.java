package com.fer.librosViejos.client.pages.home;

import com.fer.librosViejos.client.pages.home.tabs.MisAnunciosUI;
import com.fer.librosViejos.client.pages.home.tabs.OtrosAnuncios;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class HomeUI extends Composite {

	private static HomeUIUiBinder uiBinder = GWT.create(HomeUIUiBinder.class);

	interface HomeUIUiBinder extends UiBinder<Widget, HomeUI> {
	}
	
	@UiField Anchor aMisAnuncios;
	@UiField Anchor aOtrosAnuncios;
	@UiField Anchor aActualizarUniversidad;
	@UiField Anchor aProfile;
	
	@UiField Element liMisAnuncios;
	@UiField Element liOtrosAnuncios;
	@UiField Element liActualizarUniversidad;
	@UiField Element liProfile;
	
	@UiField HTMLPanel tabPanel;

	public HomeUI() {
		initWidget(uiBinder.createAndBindUi(this));
		
		tabPanel.clear();
		tabPanel.add(new MisAnunciosUI());
	}

	@UiHandler("aMisAnuncios")
	void onClickMisAnuncios(ClickEvent e)
	{
		liMisAnuncios.setClassName("active");
		liOtrosAnuncios.setClassName("");
		liActualizarUniversidad.setClassName("");
		liProfile.setClassName("");
		
		tabPanel.clear();
		tabPanel.add(new MisAnunciosUI());
	}
	
	@UiHandler("aOtrosAnuncios")
	void onClickOtrosAnuncios(ClickEvent e)
	{
		liMisAnuncios.setClassName("");
		liOtrosAnuncios.setClassName("active");
		liActualizarUniversidad.setClassName("");
		liProfile.setClassName("");
		
		tabPanel.clear();
		tabPanel.add(new OtrosAnuncios());
	}
	
	@UiHandler("aActualizarUniversidad")
	void onClickActualizar(ClickEvent e)
	{
		liMisAnuncios.setClassName("");
		liOtrosAnuncios.setClassName("");
		liActualizarUniversidad.setClassName("active");
		liProfile.setClassName("");
	}
	
	@UiHandler("aProfile")
	void onClickProfile(ClickEvent e)
	{
		liMisAnuncios.setClassName("");
		liOtrosAnuncios.setClassName("");
		liActualizarUniversidad.setClassName("");
		liProfile.setClassName("active");
		
	}
	
	
	
	

}
