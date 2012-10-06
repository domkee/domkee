package com.fer.librosViejos.test.mocks;

import java.util.List;

import junit.framework.TestCase;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.model.TipoAnuncio;
import com.fer.librosViejos.server.persistence.test.MockAnuncioPersistence;

public class TestMockAnuncioPersistence extends TestCase{

	private MockAnuncioPersistence anuncioPersistence;
	
	public void setup()
	{
		anuncioPersistence = new MockAnuncioPersistence();
	}
	
	public void testCreateAnuncio()
	{
		setup();
		List<Anuncio> resOriginal = anuncioPersistence.getFromUser("dueno");
		
		int size = resOriginal.size();
		
		Anuncio a = new Anuncio().init("1", "dueno", "anuncio bacano", 10, TipoAnuncio.libro,"");
		anuncioPersistence.create(a);
		
		a = new Anuncio().init("2", "dueno", "anuncio bacano", 20, TipoAnuncio.libro,"");
		anuncioPersistence.create(a);
		
		a = new Anuncio().init("3", "dueno", "anuncio bacano", 30, TipoAnuncio.libro,"");
		anuncioPersistence.create(a);
		
		a = new Anuncio().init("4", "dueno", "anuncio bacano", 40, TipoAnuncio.libro,"");
		anuncioPersistence.create(a);
		
		List<Anuncio> res = anuncioPersistence.getFromUser("dueno");
		
		for (Anuncio an : res) {
			System.out.println(an.getId() +", "+ an.getName() +", "+ an.getPrice() + "," + a.getOwner());
		}
		
		res.removeAll(resOriginal);
		assertEquals(4, res.size());
		for (Anuncio anuncio : res) {
			String name = anuncio.getName();
			double price = anuncio.getPrice();
			for (int i = 1; i < 5; i++) {
				if (name.equals(""+i))
				{
					
					assertEquals(price,(double) i*10);
				}
			}
		}
		
		if (size>15)
		{
			anuncioPersistence.flush();
		}
	}
	
}
