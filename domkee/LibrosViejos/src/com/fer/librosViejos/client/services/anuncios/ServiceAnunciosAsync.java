package com.fer.librosViejos.client.services.anuncios;

import java.util.Collection;
import java.util.List;

import com.fer.librosViejos.client.model.Anuncio;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceAnunciosAsync {

	void createAnuncio(Anuncio book, AsyncCallback<Long> callback);

	void getAnuncios(AsyncCallback<List<Anuncio>> callback);

	void searchLibros(String searchTerm, AsyncCallback<Collection<Anuncio>> callback);

	void getAnuncio(String anuncioID, AsyncCallback<Anuncio> callback);

	void deleteAnuncio(Anuncio a, AsyncCallback<Void> callback);

}
