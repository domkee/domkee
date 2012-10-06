package com.fer.librosViejos.client.widget;

import com.fer.librosViejos.client.Pages;
import com.fer.t1.client.PageManager;
import com.fer.t1.client.widgets.fb.FBInviteDialog;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class NavBar extends Composite implements ClickHandler, ValueChangeHandler<String> {
	
	private TextBox txtSearch;
	private Image lblNewLabel;
	private Label lblInvitarAmigos;
	
	public NavBar() {
	
		initWidget(new TopNavbar());
		setStyleName("");
	}

	private void onSearch()
	{
		String query = txtSearch.getValue();
		if (query.length() > 1)
		{
			PageManager.goTo(Pages.SEARCH, "q",query);
		}
	}
	
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		onSearch();
	}

	@Override
	public void onClick(ClickEvent event) {
		
		Object source = event.getSource();
		if (source.equals(lblNewLabel))
		{
			onSearch();
		}
		else if(source.equals(lblInvitarAmigos))
		{
			FBInviteDialog.openDialog("Invita a tus amigos a vender sus libros usados");
		}
	}

	
	
}
