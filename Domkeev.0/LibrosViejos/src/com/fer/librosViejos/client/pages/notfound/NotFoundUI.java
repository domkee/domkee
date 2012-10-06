package com.fer.librosViejos.client.pages.notfound;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NotFoundUI extends Composite {

	private static NotFoundUIUiBinder uiBinder = GWT
			.create(NotFoundUIUiBinder.class);

	interface NotFoundUIUiBinder extends UiBinder<Widget, NotFoundUI> {
	}

	public NotFoundUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
