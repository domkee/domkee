package com.fer.librosViejos.server.services.userfb;

import javax.servlet.http.Cookie;

import com.fer.librosViejos.client.model.User;
import com.fer.librosViejos.client.services.userfb.ServiceFBUser;
import com.fer.librosViejos.server.persistence.user.IUserPersistenceControl;
import com.fer.librosViejos.server.persistence.user.UserPersistenceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ServiceFBUserImpl extends RemoteServiceServlet implements ServiceFBUser{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6160135074210849246L;

	private IUserPersistenceControl persistenceControl;
	
	public final static String SESSION_TOKEN = "TOKEN";
	
	@Override
	public User getUser(String token) {
		persistenceControl = UserPersistenceFactory.get();
		Cookie c = new Cookie("token", token);
		perThreadRequest.get().getSession().setAttribute(SESSION_TOKEN, token);
		return persistenceControl.get(token);
		
	}
	
	
	
	
	
	

}
