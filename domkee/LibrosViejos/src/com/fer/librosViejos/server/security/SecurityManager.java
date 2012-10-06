package com.fer.librosViejos.server.security;

import com.fer.librosViejos.client.model.User;
import com.fer.librosViejos.server.persistence.user.IUserPersistenceControl;
import com.fer.librosViejos.server.persistence.user.UserPersistenceFactory;

public class SecurityManager {

	IUserPersistenceControl persistenceControl;
	
	public SecurityManager() {
		persistenceControl = UserPersistenceFactory.get();
	}
	
	/**
	 * 
	 * @param accessToken
	 * @return returns a user based on an accessToken or NULL if the token is not found
	 */
	public User getUser(String accessToken)
	{
		return persistenceControl.getUserWithToken(accessToken);
	}
	
	/**
	 * 
	 * @param accessToken
	 * @return returns a user id based on an accessToken or NULL if the token is not found
	 */
	public String getUserId(String accessToken)
	{
		return getUser(accessToken).getId();
	}
}
