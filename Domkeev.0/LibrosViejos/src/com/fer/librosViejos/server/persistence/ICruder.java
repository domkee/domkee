package com.fer.librosViejos.server.persistence;

public interface ICruder<T,Id> {

	public Id create(T object);
	public void update(Id id, T newObject);
	public void delete(Id id);
	public T get(Id id); 
}
