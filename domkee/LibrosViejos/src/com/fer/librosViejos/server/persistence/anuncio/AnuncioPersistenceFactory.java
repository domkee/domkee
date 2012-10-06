package com.fer.librosViejos.server.persistence.anuncio;

import com.fer.librosViejos.server.persistence.PersistenceVars;
import com.fer.librosViejos.server.persistence.test.MockAnuncioPersistence;


public class AnuncioPersistenceFactory {

	public static IAnuncioPersistence get()
	{
		if (PersistenceVars.DEBUG = true)
		{
			return new MockAnuncioPersistence();
		}
		else
		{
			return null;
		}
	}


	
}
