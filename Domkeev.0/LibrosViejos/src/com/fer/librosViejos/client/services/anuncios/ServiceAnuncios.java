/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fer.librosViejos.client.services.anuncios;

import java.util.Collection;
import java.util.List;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.t1.client.exceptions.Exception404;
import com.fer.t1.client.exceptions.NotLoggedInException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ServiceAnuncios")
public interface ServiceAnuncios extends RemoteService {

	/**
	 * 
	 * @param book
	 * @return the id of the newly created Anuncio
	 * @throws NotLoggedInException 
	 */
	public long createAnuncio(Anuncio book) throws NotLoggedInException;
	/**
	 * 
	 * @param userId
	 * @return the list of Anuncio's owned by the currently logged user.
	 * This method implies that the server either knows that the user has logged
	 * in and knows his id or else redirects the user to a log-in website
	 * @throws Exception404 in case the userId is not found
	 * @throws NotLoggedInException 
	 */
	public List<Anuncio> getAnuncios() throws Exception404, NotLoggedInException;
	/**
	 * 
	 * @param anuncioID
	 * @return returns an Anuncio based on the id
	 * @throws Exception404 in case the specified anuncioID does not exist or is not found
	 */
	public Anuncio getAnuncio(String anuncioID) throws Exception404;
	/**
	 * 
	 * @param searchTerm
	 * @return returns a Collection of anuncios based on a searchTerm
	 */
	public Collection<Anuncio> searchLibros(String searchTerm);
	/**
	 * Removes an anuncio and all of it's dependencies
	 * @param a
	 */
	public void deleteAnuncio(Anuncio a);
}
