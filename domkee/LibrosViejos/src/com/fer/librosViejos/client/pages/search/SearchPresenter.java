package com.fer.librosViejos.client.pages.search;

import java.util.Collection;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.services.anuncios.ServiceAnuncios;
import com.fer.librosViejos.client.services.anuncios.ServiceAnunciosAsync;
import com.fer.t1.client.PageStarter;
import com.fer.t1.client.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SearchPresenter extends Presenter<SearchHandler> implements
		SearchHandler {

	ServiceAnunciosAsync serviceBooks = GWT.create(ServiceAnuncios.class);
	
	@Override
	public void onPageSet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSearch(String value) {
		History.newItem(PageStarter.getURL(SearchHistoryManager.class)+"/q="+value);
	}

	@Override
	public void doSearch(String query) {
		serviceBooks.searchLibros(query, new AsyncCallback<Collection<Anuncio>>() {
			
			@Override
			public void onSuccess(Collection<Anuncio> result) {
				getView().displaySearchResults(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				view.onError("Error al intentar la busqueda, por favor recargue la página");
			}
		});
	}
	
	private SearchView getView()
	{
		return (SearchView) view;
	}
}
