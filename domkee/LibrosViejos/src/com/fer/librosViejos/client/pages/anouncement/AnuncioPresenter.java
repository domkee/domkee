package com.fer.librosViejos.client.pages.anouncement;

import com.fer.librosViejos.client.LibrosViejos;
import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.services.anuncios.ServiceAnuncios;
import com.fer.librosViejos.client.services.anuncios.ServiceAnunciosAsync;
import com.fer.t1.client.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AnuncioPresenter extends Presenter<AnuncioHandler> implements AnuncioHandler{

	ServiceAnunciosAsync serviceAnuncio = GWT.create(ServiceAnuncios.class);
	
	@Override
	public void onPageSet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadAnuncio(String id) {
		serviceAnuncio.getAnuncio(id, new AsyncCallback<Anuncio>() {
			
			@Override
			public void onSuccess(Anuncio result) {
				getView().draw(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				LibrosViejos.goTo404();
			}
		});
	}
	

	private AnuncioView getView() {
		return (AnuncioView)view;
	}

}
