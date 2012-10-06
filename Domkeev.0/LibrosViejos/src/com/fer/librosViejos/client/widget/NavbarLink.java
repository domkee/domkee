package com.fer.librosViejos.client.widget;

import com.google.gwt.user.client.ui.HTML;

public class NavbarLink extends HTML {

	public NavbarLink(String text, String url, boolean alignLeft) {
		super("<a class=\"navBarLink"+getAlignment(alignLeft)+"\" href=\"#"+url+"\"> "+text+" </a>");
	}

	private static String getAlignment(boolean alignmentLeft) {
		if (alignmentLeft == true)
		{
			return "Left";
		}
		return "Right";
	}
	
}
