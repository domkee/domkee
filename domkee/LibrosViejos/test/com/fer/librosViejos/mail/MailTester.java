package com.fer.librosViejos.mail;

import java.util.Date;

import org.apache.commons.mail.EmailException;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.model.User;
import com.fer.librosViejos.server.mail.MailSender;

public class MailTester {

	
	/**
	 * @param args
	 * @throws EmailException 
	 */
	public static void main(String[] args) throws EmailException {
		MailSender mailSender = new MailSender();
		
		User sender = new User().init("100001597450600", "Fernando", "fernandohur@gmail.com",new Date(), "M");
		Anuncio a = new Anuncio();
		a.setId(1L);
		
		mailSender.sendBookContactMail(sender,sender, a);
		
	}

}
