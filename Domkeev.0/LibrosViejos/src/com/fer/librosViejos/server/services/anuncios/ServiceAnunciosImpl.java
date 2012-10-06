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
package com.fer.librosViejos.server.services.anuncios;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.model.User;
import com.fer.librosViejos.client.services.anuncios.ServiceAnuncios;
import com.fer.librosViejos.server.persistence.anuncio.AnuncioPersistenceFactory;
import com.fer.librosViejos.server.persistence.anuncio.IAnuncioPersistence;
import com.fer.librosViejos.server.search.ISearchEngine;
import com.fer.librosViejos.server.search.SearchEngineFactory;
import com.fer.librosViejos.server.security.SecurityManager;
import com.fer.t1.client.exceptions.Exception404;
import com.fer.t1.client.exceptions.NotLoggedInException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ServiceAnunciosImpl extends RemoteServiceServlet implements ServiceAnuncios {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7678788467822072917L;

	IAnuncioPersistence persistenceControl;
	ISearchEngine searchEngine;
	
	
	
	public ServiceAnunciosImpl() {
		super();
		persistenceControl = AnuncioPersistenceFactory.get();
		searchEngine = SearchEngineFactory.get();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		
		HttpSession session = req.getSession();
		String accessToken = (String) session.getAttribute("TOKEN");
		System.out.println("[SERVER] ACCESS_TOKEN: "+accessToken);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		String accessToken = (String) session.getAttribute("TOKEN");
		System.out.println("[SERVER] ACCESS_TOKEN: "+accessToken);
	}
	
	@Override
	public long createAnuncio(Anuncio book) throws NotLoggedInException {
		
		book.setOwner(getUserId());
		
		long id = persistenceControl.create(book);
		searchEngine.index(book);
		return id;
	}

	@Override
	public List<Anuncio> getAnuncios() throws NotLoggedInException{
		return persistenceControl.getFromUser(getUserId());
	}

	@Override
	public Collection<Anuncio> searchLibros(String searchTerm) {
		return searchEngine.search(searchTerm);
	}
	
	@Override
	public Anuncio getAnuncio(String anuncioID) throws Exception404{
		try {
			Anuncio a = persistenceControl.get(Long.parseLong(anuncioID));
			if (a==null)
			{
				throw new Exception();
			}
			else
			{
				return a;
			}
		} catch (Exception e) {
			throw new Exception404("El anuncio con id: "+anuncioID+ " no fue encontrado en el servidor");
		}
		
	}
	
	@Override
	public void deleteAnuncio(Anuncio a) {
		persistenceControl.delete(a.getId());
		searchEngine.removeFromIndex(a);
	}
	
	public String getUserId() throws NotLoggedInException
	{
		String accessToken = (String) perThreadRequest.get().getSession().getAttribute("TOKEN");
		
		
		User user = new SecurityManager().getUser(accessToken);
		if (user==null)
		{
			throw new NotLoggedInException();
		}
		String userId = user.getId();
		return userId;
	}
}
