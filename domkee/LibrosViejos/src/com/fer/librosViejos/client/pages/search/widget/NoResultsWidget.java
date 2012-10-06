package com.fer.librosViejos.client.pages.search.widget;

import com.fer.t1.client.widgets.fb.FBInviteDialog;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NoResultsWidget extends Composite {

	private static NoResultsWidgetUiBinder uiBinder = GWT
			.create(NoResultsWidgetUiBinder.class);

	interface NoResultsWidgetUiBinder extends UiBinder<Widget, NoResultsWidget> {
	}
	
	@UiField
	Button btnInvite;

	public NoResultsWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("btnInvite")
	public void onClick(ClickEvent e)
	{
		FBInviteDialog.openDialog("Hola estoy buscando X, me podrias ayudar a encontrarlo");
	}
}
