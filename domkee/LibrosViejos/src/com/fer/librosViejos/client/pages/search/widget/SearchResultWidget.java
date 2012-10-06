package com.fer.librosViejos.client.pages.search.widget;

import com.fer.librosViejos.client.model.Anuncio;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class SearchResultWidget extends Composite {

	private static SearchResultWidgetUiBinder uiBinder = GWT
			.create(SearchResultWidgetUiBinder.class);

	NumberFormat decimalFormat = NumberFormat.getDecimalFormat();
	
	@UiField Element txtNombre;
	@UiField Element txtPrecio;
	@UiField Element txtUsuario;
	@UiField Element txtDescripcion;
	@UiField Image img;
	
	interface SearchResultWidgetUiBinder extends
			UiBinder<Widget, SearchResultWidget> {
	}

	
	@UiField Panel focusPanel;
	@UiField AnchorElement btnMas;
	
	public SearchResultWidget(Anuncio a) {
		initWidget(uiBinder.createAndBindUi(this));
		
		
		
		txtNombre.setInnerText(a.getName());
		String description = a.getDescription();
		if (description.length()>31);
		{
			description = description.substring(0, 30)+" ...";
		}
		txtDescripcion.setInnerText(description);
		txtPrecio.setInnerText("$"+NumberFormat.getDecimalFormat().format(a.getPrice()));
		txtUsuario.setInnerText(a.getOwner());
		if(a.getImageURL()!=null)
		{
			img.setUrl(a.getImageURL());
		}
		
		btnMas.setHref("#anuncio/id="+a.getId());
		
	}


	public SearchResultWidget(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


}
