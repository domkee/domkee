package com.fer.librosViejos.client.pages.anouncement;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.t1.client.widgets.fb.FBComment;
import com.fer.t1.client.widgets.fb.FBLike;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AnuncioUI extends Composite {

	private static AnuncioUIUiBinder uiBinder = GWT
			.create(AnuncioUIUiBinder.class);

	interface AnuncioUIUiBinder extends UiBinder<Widget, AnuncioUI> {
	}

	@UiField Button btnContactar;
	@UiField FBComment fbComment;
	@UiField FBLike fbLike;
	@UiField Element txtNombre;
	@UiField Element txtDescripcion;
	@UiField ImageElement img;
	
	public AnuncioUI(Anuncio result) {
		initWidget(uiBinder.createAndBindUi(this));
		
		//String url = GWT.getModuleBaseURL()+"#anuncio/id="+result.getId();
		
		
		txtNombre.setInnerText(result.getName());
		txtDescripcion.setInnerText(result.getDescription());
		if(result.getImageURL()!=null)
		{
			img.setSrc(result.getImageURL());
		}
	}

	@UiHandler("btnContactar")
	void onClick(ClickEvent e)
	{
		Window.alert("enviado");
	}
}
