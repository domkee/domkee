package com.fer.librosViejos.client.model;

import java.io.Serializable;

public class Anuncio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7124496964633194931L;
	private Long id;
	private String name;
	private String owner;
	private String description;
	private double price;
	private TipoAnuncio tipo;
	private String imageURL;
	private String gay;
	
	public Anuncio init(String name, String owner, String description,
			double price, TipoAnuncio tipo, String imageURL) {
		this.name = name;
		this.owner = owner;
		this.description = description;
		this.price = price;
		this.tipo = tipo;
		this.imageURL = imageURL;
		return this;
	}
	
	
	
	public String getImageURL() {
		return imageURL;
	}
	
	public TipoAnuncio getTipo() {
		return tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "("+id+","+ name+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Anuncio)
		{
			return id == ((Anuncio)obj).id;
		}
		return super.equals(obj);
	}

	public void setId(Long id) {
		this.id = id;
	}



	public void setOwner(String owner) {
		this.owner = owner;
	}
}
