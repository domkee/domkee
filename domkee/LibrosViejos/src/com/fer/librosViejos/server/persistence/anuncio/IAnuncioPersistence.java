package com.fer.librosViejos.server.persistence.anuncio;

import java.util.List;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.server.persistence.ICruder;

public interface IAnuncioPersistence extends ICruder<Anuncio, Long>{


	public List<Anuncio> getFromUser(String userId);
}
