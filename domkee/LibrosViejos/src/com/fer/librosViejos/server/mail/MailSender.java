package com.fer.librosViejos.server.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.fer.librosViejos.client.model.Anuncio;
import com.fer.librosViejos.client.model.User;
import com.fer.librosViejos.server.utils.PageUtils;

public class MailSender {

	
	public void sendBookContactMail(User receiver, User sender, Anuncio a) throws EmailException
	{
		
		String html = ""+
				"<h1> Hola! </h1>"+
				"<p>  <a href=\"https://facebook.com/"+sender.getId()+"\">"+ sender.getName() +"</a> esta interesado en tu <a href=\""+PageUtils.anuncioPage(a)+"\" >anuncio</a>, para contactarlo puedes comuncarte con el utilizando este correo <b>"+sender.getEmail()+"</b>. </p>"
				+ "<p> Si no deseas comunicarte con <a href=\"https://facebook.com/"+sender.getId()+"\"> puedes ignorar este mensaje </p>";
		
		
		HtmlEmail email = new HtmlEmail();
		String authuser = "support@woojah.com";
		String authpwd = "V3jc8D2S";
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator(authuser, authpwd));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.getMailSession().getProperties().put("mail.smtps.auth", "true");
		email.getMailSession().getProperties().put("mail.debug", "true");
		email.getMailSession().getProperties().put("mail.smtps.port", "587");
		email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", "587");
		email.getMailSession().getProperties().put("mail.smtps.socketFactory.class",   "javax.net.ssl.SSLSocketFactory");
		email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
		email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
		email.setFrom("fernando@woojah.com", "LibrosViejos");
		email.addTo(receiver.getEmail());
		email.setSubject("LibrosViejos | te han contactado para comprar un libro");
		email.setHtmlMsg(html);
		email.setTLS(true);
		email.send();
	}
	
			
	
}
