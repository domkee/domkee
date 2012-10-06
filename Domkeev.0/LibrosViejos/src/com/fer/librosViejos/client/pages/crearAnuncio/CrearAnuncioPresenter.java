package com.fer.librosViejos.client.pages.crearAnuncio;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.model.TipoAnuncio;
import com.fer.librosViejos.client.services.anuncios.ServiceAnuncios;
import com.fer.librosViejos.client.services.anuncios.ServiceAnunciosAsync;
import com.fer.librosViejos.client.widget.DefaultPopup;
import com.fer.t1.client.Presenter;
import com.fer.t1.client.azync.AWLCallback;
import com.google.gwt.core.client.GWT;

public class CrearAnuncioPresenter extends Presenter<CrearAnuncioHandler> implements
CrearAnuncioHandler {

	ServiceAnunciosAsync serviceBooks = GWT.create(ServiceAnuncios.class);

	@Override
	public void onPageSet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreateAnuncio(String nombre, String descripcion, double precio, String imageURL) {
		Anuncio b = new Anuncio().init(nombre, "", descripcion, precio,TipoAnuncio.libro, imageURL);
		serviceBooks.createAnuncio(b, new AWLCallback<Long>()
				{
					@Override
					public void onSuccess(Long result) {
						getView().notifyBookCration(result);
					}
					@Override
					public void onFail(Throwable caught) {
						getView().onError("Book creation failed");
					}
					@Override
					public void onLoggedInException() {
						DefaultPopup.show("No has iniciad sesion", "Para poder continuar con esta accion debes iniciar sesion", DefaultPopup.EMPHASIS_INFO);
					}
				}
		);

	}


	private CrearAnuncioView getView()
	{
		return (CrearAnuncioView) view;
	}
}
