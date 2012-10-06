package com.fer.librosViejos.client.pages.home.tabs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class OtrosAnuncios extends Composite {

	private static OtrosAnunciosUiBinder uiBinder = GWT
			.create(OtrosAnunciosUiBinder.class);

	interface OtrosAnunciosUiBinder extends UiBinder<Widget, OtrosAnuncios> {
	}

	public OtrosAnuncios() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
