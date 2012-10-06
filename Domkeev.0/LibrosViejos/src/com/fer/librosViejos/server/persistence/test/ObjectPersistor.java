package com.fer.librosViejos.server.persistence.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectPersistor {

	/**
	 * 
	 * @param o the object to persist
	 * @param f the name of the file (file path)
	 * @throws Exception
	 */
	public static void save(Object o, String f) throws Exception
	{
		File file = new File(f);
		//System.out.println(file.getAbsolutePath());
		ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
		ous.writeObject(o);
		ous.flush();
		ous.close();
				
	}
	
	public static Object load(String file) throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object ret = ois.readObject();
		ois.close();
		return ret;
	}

}
