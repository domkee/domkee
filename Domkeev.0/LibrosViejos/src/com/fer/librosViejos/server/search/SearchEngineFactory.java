package com.fer.librosViejos.server.search;

import com.fer.librosViejos.server.persistence.PersistenceVars;

public class SearchEngineFactory {

	public static ISearchEngine get()
	{
		if (PersistenceVars.DEBUG == true)
		{
			return new MockSearchEngine();
		}
		else
		{
			return null;
		}
	}

}
