package com.fer.librosViejos.client.services.userfb;

import com.fer.librosViejos.client.model.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ServiceFBUser")
public interface ServiceFBUser extends RemoteService{

	public User getUser(String token);
	
}
