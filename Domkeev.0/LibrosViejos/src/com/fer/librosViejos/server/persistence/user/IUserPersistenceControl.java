package com.fer.librosViejos.server.persistence.user;

import com.fer.librosViejos.client.model.User;
import com.fer.librosViejos.server.persistence.ICruder;

public interface IUserPersistenceControl extends ICruder<User, String>{

	/**
	 * 
	 * @param token
	 * @return returns a usera based on an accessToken or null if not found
	 */
	public User getUserWithToken(String token);
	public void setToken(String accessToken, String userId);
		
}
