package com.fer.librosViejos.server.persistence.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fer.librosViejos.client.model.User;
import com.fer.librosViejos.server.persistence.user.IUserPersistenceControl;

public class MockUserPersistence implements IUserPersistenceControl {

	public static List<User> users = new ArrayList<User>();
	public static Map<String,String> mapTokenToUserId = new HashMap<String, String>();
	
	
	@Override
	public String create(User object) {
		users.add(object);
		return object.getId();
	}

	@Override
	public void update(String id, User newObject) {
		for (User u : users) {
			if (u.getId().equals(id))
			{
				users.remove(u);
				users.add(newObject);
			}
		}
	}

	@Override
	public void delete(String id) {
		for (User u : users) {
			if (u.getId().equals(id))
			{
				users.remove(u);
			}
		}
	}

	@Override
	public User get(String id) {
		for (User u : users) {
			if (u.getId().equals(id))
			{
				return u;
			}
		}
		return null;
	}

	@Override
	public User getUserWithToken(String token) {
		String userId = mapTokenToUserId.get(token);
		return get(userId);
	}

	@Override
	public void setToken(String accessToken, String userId) {
		mapTokenToUserId.put(accessToken, userId);
	}

}
