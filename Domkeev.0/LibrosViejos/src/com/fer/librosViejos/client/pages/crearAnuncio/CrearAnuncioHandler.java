package com.fer.librosViejos.client.pages.crearAnuncio;

import com.fer.t1.client.EventHandler;

public interface CrearAnuncioHandler extends EventHandler {

	void onCreateAnuncio(String nombre, String descripcion, double precio, String imageUrl);

}
