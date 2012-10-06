package com.fer.librosViejos.client.widget;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

public class DefaultPopup extends PopupPanel{

	public static String EMPHASIS_WARNING = "alert-block";
	public static String EMPHASIS_ERROR = "alert-error";
	public static String EMPHASIS_INFO = "alert-info";
	public static String EMPHASIS_SUCESS = "alert-success";
	
	private static DefaultPopup popup;
	
	public DefaultPopup(String title, String message, String emphasis) {
			String html = "";
			html +="<div class=\" alert "+emphasis+"\" >";
			html +="<h1> "+title+"</h1>";
			html +="<h3>"+message+"</h3>";
			html +="</div>";
			
			setWidget(new HTML(html));
			setAutoHideOnHistoryEventsEnabled(true);
			setAutoHideEnabled(true);
			setGlassEnabled(true);
			setModal(true);
			setStyleName("popup");
			setGlassStyleName("popupGlass");
	}
	
	
	
	
	public static void show(String message, String title, String emphasis)
	{
		popup = new DefaultPopup(message, title, emphasis);
		popup.show();
		popup.center();
	}

}
