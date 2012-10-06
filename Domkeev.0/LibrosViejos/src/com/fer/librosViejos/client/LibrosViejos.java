package com.fer.librosViejos.client;

import com.fer.librosViejos.client.pages.anouncement.AnuncioHistory;
import com.fer.librosViejos.client.pages.anouncement.AnuncioPresenter;
import com.fer.librosViejos.client.pages.anouncement.AnuncioView;
import com.fer.librosViejos.client.pages.crearAnuncio.CrearAnuncioHistory;
import com.fer.librosViejos.client.pages.crearAnuncio.CrearAnuncioPresenter;
import com.fer.librosViejos.client.pages.crearAnuncio.CrearAnuncioView;
import com.fer.librosViejos.client.pages.home.HomeHistory;
import com.fer.librosViejos.client.pages.home.HomePresenter;
import com.fer.librosViejos.client.pages.home.HomeView;
import com.fer.librosViejos.client.pages.notfound.NotFoundHistory;
import com.fer.librosViejos.client.pages.notfound.NotFoundPresenter;
import com.fer.librosViejos.client.pages.notfound.NotFoundView;
import com.fer.librosViejos.client.pages.search.SearchHistoryManager;
import com.fer.librosViejos.client.pages.search.SearchPresenter;
import com.fer.librosViejos.client.pages.search.SearchView;
import com.fer.t1.client.PageStarter;
import com.fer.t1.client.widgets.LoadingWidget;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;

public class LibrosViejos implements EntryPoint{

	@Override
	public void onModuleLoad() {
		LoadingWidget.init("images/loading.gif");
		LoadingWidget.show();
		
		PageStarter.start("mainPanel");
		PageStarter.startPage(
				new HomeHistory(), 
				new HomePresenter(), 
				new HomeView(), 
				Pages.HOME);
		PageStarter.startPage(
				new SearchHistoryManager(),
				new SearchPresenter(), 
				new SearchView(), 
				Pages.SEARCH);
		
		PageStarter.startPage(
				new CrearAnuncioHistory(),
				new CrearAnuncioPresenter(),
				new CrearAnuncioView(),
				Pages.CREAR_ANUNCIO);
		
		PageStarter.startPage(
				new AnuncioHistory(),
				new AnuncioPresenter(),
				new AnuncioView(),
				Pages.ANUNCIO);
		
		PageStarter.startPage(
				new NotFoundHistory(),
				new NotFoundPresenter(),
				new NotFoundView(),
				"notfound");
		
		History.fireCurrentHistoryState();
	}

	public static void goTo404()
	{
		PageStarter.drawPage("notfound");
	}

}
