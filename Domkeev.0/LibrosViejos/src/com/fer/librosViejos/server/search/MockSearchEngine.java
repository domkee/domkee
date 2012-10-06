package com.fer.librosViejos.server.search;

import java.util.ArrayList;
import java.util.List;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.server.persistence.test.ObjectPersistor;

public class MockSearchEngine implements ISearchEngine{

	private static ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
	private static String FILE_NAME = "searchEngine.txt";
	
	@SuppressWarnings("unchecked")
	public MockSearchEngine()
	{
		try {
			anuncios = (ArrayList<Anuncio>) ObjectPersistor.load(FILE_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Anuncio> search(String query) {
		
		ArrayList<Anuncio> res = new ArrayList<Anuncio>();
		
		for (Anuncio a : anuncios) {
			if (a.getDescription().contains(query))
			{
				res.add(a);
			}
		}
		
		return res;
	}
	
	public void index(Anuncio a)
	{
		anuncios.add(a);
		save();
	}
	
	private void save() {
		try {
			ObjectPersistor.save(anuncios, FILE_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeFromIndex(Anuncio a) {
		anuncios.remove(a);
		save();
	}

}
