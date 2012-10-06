package com.fer.librosViejos.client.widget;

import com.fer.librosViejos.client.Pages;
import com.fer.t1.client.PageManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class TopNavbar extends Composite implements ValueChangeHandler<String>{

	private static TopNavbarUiBinder uiBinder = GWT
			.create(TopNavbarUiBinder.class);

	interface TopNavbarUiBinder extends UiBinder<Widget, TopNavbar> {
	}
	
	@UiField Element liCrearAnuncio;
	@UiField Element liHome;
	@UiField Element liContact;
	
	@UiField TextBox txtSearch;
	@UiField Button btnSearch;

	public TopNavbar() {
		initWidget(uiBinder.createAndBindUi(this));
		History.addValueChangeHandler(this);
		
		txtSearch.getElement().setAttribute("placeholder", "buscar");
		txtSearch.addValueChangeHandler(this);
	}


	public TopNavbar(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("btnSearch")
	void onSearch(ClickEvent e)
	{
		search();
	}

	@UiHandler("linkCrearAnuncio")
	void onClickCrearAnuncio(ClickEvent e)
	{
		liCrearAnuncio.setClassName("active");
	}


	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		Object source =event.getSource();
		String value = event.getValue();
		if (source!=null && source.equals(txtSearch))
		{
			search();
		}
		else
		{
			if (value.startsWith("crearAnuncio"))
			{
				liCrearAnuncio.setClassName("active");
				liHome.setClassName("");
				liContact.setClassName("");
			}
			else if (value.startsWith("contact"))
			{
				liCrearAnuncio.setClassName("");
				liHome.setClassName("");
				liContact.setClassName("active");
			}
			else if (value.startsWith("home"))
			{
				liCrearAnuncio.setClassName("");
				liHome.setClassName("active");
				liContact.setClassName("");
			}
			else if (value.startsWith("search"))
			{
				liCrearAnuncio.setClassName("");
				liHome.setClassName("");
				liContact.setClassName("");
			}
		}
	}


	private void search() {
		if (txtSearch.getValue().length()>0)
		{
			//History.newItem("search/q="+txtSearch.getText());
			PageManager.goTo(Pages.SEARCH, "q",txtSearch.getValue());
		}
	}
	 

}
