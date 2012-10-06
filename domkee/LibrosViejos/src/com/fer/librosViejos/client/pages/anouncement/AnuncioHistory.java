package com.fer.librosViejos.client.pages.anouncement;

import java.util.Map;

import com.fer.t1.client.HistoryManager;

public class AnuncioHistory extends HistoryManager {

	@Override
	public void onHistoryChange(Map<String, String> mapa) {
		String anuncioId = mapa.get("id");
		((AnuncioHandler)handler).loadAnuncio(anuncioId);
		draw();
	}

}
