package com.fer.librosViejos.server.utils;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.server.persistence.PersistenceVars;

public class PageUtils {

	public static String anuncioPage(Anuncio a)
	{
		if(PersistenceVars.DEBUG==true)
		{
			return "http://127.0.0.1:8888/LibrosViejos.html?gwt.codesvr=127.0.0.1:9997#anuncio/id="+a.getId();
		}
		else
		{
			return "";
		}
	}

}
