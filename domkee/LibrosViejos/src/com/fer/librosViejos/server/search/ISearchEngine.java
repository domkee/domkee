package com.fer.librosViejos.server.search;

import java.util.List;

import com.fer.librosViejos.client.model.Anuncio;

public interface ISearchEngine {

	public List<Anuncio> search(String query);
	public void index(Anuncio a);
	public void removeFromIndex(Anuncio a);
	
}
