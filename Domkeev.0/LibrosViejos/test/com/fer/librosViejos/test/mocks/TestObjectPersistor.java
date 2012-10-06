package com.fer.librosViejos.test.mocks;

import java.io.File;

import com.fer.librosViejos.server.persistence.test.ObjectPersistor;

import junit.framework.TestCase;

public class TestObjectPersistor extends TestCase{

	public void testOP()
	{
		for (int i=0; i<100 ; i++) {
			String file = "testFiles/anuncios"+i+".txt";
			try {
				File f = new File(file);
				ObjectPersistor.save(new Integer(i), file);
				Integer integer = (Integer)ObjectPersistor.load(file);
				assertEquals(integer.intValue(), i);
				f.delete();
			} catch (Exception e) {
				e.printStackTrace();
				fail();
			}
			
		}
			
		
	}

}
