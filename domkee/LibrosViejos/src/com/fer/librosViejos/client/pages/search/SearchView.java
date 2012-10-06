package com.fer.librosViejos.client.pages.search;

import java.util.Collection;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.pages.search.widget.NoResultsWidget;
import com.fer.librosViejos.client.pages.search.widget.SearchResultWidget;
import com.fer.librosViejos.client.widget.NavBar;
import com.fer.t1.client.View;
import com.fer.t1.client.widgets.WidgetTag;
import com.google.gwt.user.client.ui.FlowPanel;

public class SearchView extends View<SearchHandler> {
	
	private FlowPanel panelSearchResults;
	
	public SearchView() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		setStyleName("container");
		
		NavBar navBar = new NavBar();
		flowPanel.add(navBar);
		
		flowPanel.add(new WidgetTag("legend", "Buscar anuncios"));
				
		panelSearchResults = new FlowPanel();
		flowPanel.add(panelSearchResults);
	}


	public void displaySearchResults(Collection<Anuncio> result) {

		panelSearchResults.clear();
		NoResultsWidget noRes = new NoResultsWidget();
		if(result.size()==0)
		{
			panelSearchResults.add(noRes);
		}
		for (Anuncio book : result) {
			panelSearchResults.add(new SearchResultWidget(book));
		}
	}


}
