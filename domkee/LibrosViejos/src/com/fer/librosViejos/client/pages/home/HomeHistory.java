package com.fer.librosViejos.client.pages.home;

import java.util.Map;

import com.fer.librosViejos.client.CookieNames;
import com.fer.t1.client.HistoryManager;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;

public class HomeHistory extends HistoryManager {

	public final static String HISTORY_TAB_MIS_ANUNCIOS = "misAnuncio";
	public final static String HISTORY_TAB_OTROS_ANUNCIOS = "otrosAnuncio";
	public final static String HISTORY_TAB_PERFIL = "perfil";
	public final static String HISTORY_TAB = "tab";
	
	
	@Override
	public void onHistoryChange(Map<String, String> params) {
		String token = params.get("token");
		if (token!=null)
		{
			Cookies.setCookie(CookieNames.token, token);
			History.newItem(url, true);
			getHandler().loadUserData();
			getHandler().loadMessages();
		}
		
	}

	HomeHandler getHandler()
	{
		return (HomeHandler)handler;
	}
}
