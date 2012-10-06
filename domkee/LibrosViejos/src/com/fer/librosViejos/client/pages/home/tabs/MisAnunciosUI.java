package com.fer.librosViejos.client.pages.home.tabs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MisAnunciosUI extends Composite {

	private static MisAnunciosUIUiBinder uiBinder = GWT
			.create(MisAnunciosUIUiBinder.class);

	interface MisAnunciosUIUiBinder extends UiBinder<Widget, MisAnunciosUI> {
	}

	public MisAnunciosUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
