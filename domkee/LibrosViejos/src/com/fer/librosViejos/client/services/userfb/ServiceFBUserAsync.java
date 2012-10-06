package com.fer.librosViejos.client.services.userfb;

import com.fer.librosViejos.client.model.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceFBUserAsync {

	void getUser(String token, AsyncCallback<User> callback);

}
