package com.fer.librosViejos.server.persistence.user;

import com.fer.librosViejos.server.persistence.PersistenceVars;
import com.fer.librosViejos.server.persistence.test.MockUserPersistence;

public class UserPersistenceFactory {

	
	public static IUserPersistenceControl get()
	{
		if (PersistenceVars.DEBUG = true)
		{
			return new MockUserPersistence();
		}
		else 
		{
			return null;
		}
	}
}
