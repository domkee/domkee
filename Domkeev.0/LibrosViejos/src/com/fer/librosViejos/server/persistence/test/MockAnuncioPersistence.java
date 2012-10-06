package com.fer.librosViejos.server.persistence.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.server.persistence.anuncio.IAnuncioPersistence;


public class MockAnuncioPersistence implements IAnuncioPersistence {

	
	private static HashMap<Long, Anuncio> anuncios = new HashMap<Long, Anuncio>();
	private static String FILE_NAME = "anuncios.txt";
	
	public MockAnuncioPersistence() {
		load();
	}
	
	@SuppressWarnings("unchecked")
	private void load() {
		try {
			Object temp = ObjectPersistor.load(FILE_NAME);
			anuncios = (HashMap<Long, Anuncio>) temp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Long create(Anuncio object) {
		object.setId((long) anuncios.size());
		anuncios.put(object.getId(), object);
		save();
		return object.getId();
	}
	
	void save()
	{
		 try {
				ObjectPersistor.save(anuncios, FILE_NAME);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void update(Long id, Anuncio newObject) {
		delete(id);
		create(newObject);
		 save();
	}

	@Override
	public void delete(Long id) {
		anuncios.remove(id);
		save();
	}

	@Override
	public Anuncio get(Long id) {
		return anuncios.get(id);
	}

	
	@Override
	public List<Anuncio> getFromUser(String userId) {
		ArrayList<Anuncio> res = new ArrayList<Anuncio>();
		Collection<Long> anunciosKeys = anuncios.keySet();
		for (Long long1 : anunciosKeys) {
			Anuncio a = anuncios.get(long1);
			if (a.getOwner().equals(userId))
			{
				res.add(a);
			}
		}
		return res;
	}

	public void flush() {
		anuncios.clear();
		save();
	}
}
