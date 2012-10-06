package com.fer.librosViejos.client.pages.home;

import com.fer.librosViejos.client.CookieNames;
import com.fer.librosViejos.client.GlobalData;
import com.fer.librosViejos.client.model.User;
import com.fer.librosViejos.client.services.userfb.ServiceFBUser;
import com.fer.librosViejos.client.services.userfb.ServiceFBUserAsync;
import com.fer.t1.client.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class HomePresenter extends Presenter<HomeHandler> implements HomeHandler {

	private ServiceFBUserAsync serviceUser = GWT.create(ServiceFBUser.class);
	
	@Override
	public void onPageSet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadMessages() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void loadUserData() {
		String token = Cookies.getCookie(CookieNames.token);
		serviceUser.getUser(token, new AsyncCallback<User>() {
			
			@Override
			public void onSuccess(User result) {
				GlobalData.user = result;
			}
			
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
		});
	}
	

	
	private HomeView getView()
	{
		return (HomeView)view;
	}
}
