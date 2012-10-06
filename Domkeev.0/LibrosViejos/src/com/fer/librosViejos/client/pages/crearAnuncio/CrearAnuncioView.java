package com.fer.librosViejos.client.pages.crearAnuncio;

import com.fer.librosViejos.client.Pages;
import com.fer.librosViejos.client.widget.DefaultPopup;
import com.fer.librosViejos.client.widget.NavBar;
import com.fer.t1.client.PageManager;
import com.fer.t1.client.View;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;

public class CrearAnuncioView extends View<CrearAnuncioHandler> implements ClickHandler{
	
	
	private CrearAnuncioUI anuncioUI;
	private NavBar navBar;
	private FlowPanel panel;
	
	public CrearAnuncioView() {
		
		panel = new FlowPanel();
		initWidget(panel);
		
		navBar = new NavBar();
		panel.add(navBar);
		
		anuncioUI = new CrearAnuncioUI();
		panel.add(anuncioUI);
		
		anuncioUI.getSendButton().addClickHandler(this);
	}


	@Override
	public void onClick(ClickEvent event) {
		String nombre = anuncioUI.getName().getValue();
		String descripcion = anuncioUI.getDescr().getValue();
		String precioTxt = anuncioUI.getPrice().getValue();
		String imageUrl = anuncioUI.getImagePanel().getSelectedURL();

		double precio=-1;
		try {
			precio = Double.parseDouble(precioTxt);
		} catch (NumberFormatException e) {
			DefaultPopup.show("Oops!", "El precio ingresado debe ser un numero", DefaultPopup.EMPHASIS_WARNING);
		}
		if(precio==-1)
		{
			
		}
		else if (nombre.trim().length()<=10)
		{
			DefaultPopup.show("Oops!","El nombre del anuncio debe ser de mas de 10 caracteres",DefaultPopup.EMPHASIS_WARNING);
		}
		else if(descripcion.trim().length()<50)
		{
			DefaultPopup.show("Oops!","Por favor ingrese una descripcion mas grande", DefaultPopup.EMPHASIS_WARNING);
		}
		else if(imageUrl==null)
		{
			DefaultPopup.show("Oops!","Debes escoger una imagen", DefaultPopup.EMPHASIS_WARNING);
			
		}
		else
		{
			eventHandler.onCreateAnuncio(nombre,descripcion,precio, imageUrl);
		}

	}
	

	public void notifyBookCration(Long id) {
		PageManager.goTo(Pages.ANUNCIO, "id",""+id);
		DefaultPopup.show("Felicitaciones", "Tu anuncio ha sido exitosamente creado", DefaultPopup.EMPHASIS_SUCESS);
		
	}

	
	
}
