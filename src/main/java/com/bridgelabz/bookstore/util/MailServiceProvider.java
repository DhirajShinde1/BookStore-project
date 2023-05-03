/**
 * 
 */
package com.bridgelabz.bookstore.util;

import java.awt.print.Printable;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class MailServiceProvider {
	public static void sendEmail(String toEmail, String subject, String body) {

		String fromEmail = "bookstore7771@gmail.com";
		String password = "wnumgxeuqbkvbvqh";

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(prop, auth);
		send(session, fromEmail, toEmail, subject, body);
	}

	private static void send(Session session, String fromEmail, String toEmail, String subject, String body) {
		try {
			MimeMessage message = new MimeMessage(session);
			System.out.println(1);
			message.setFrom(new InternetAddress(fromEmail, "Bookstore"));
			System.out.println(2);
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			System.out.println(3);
			message.setSubject(subject);
			System.out.println(4);
			message.setText(body);
			System.out.println(5);
			Transport.send(message);
			System.out.println(6);
			
		} catch (Exception e) {
	
			System.out.println(e);
		}
	}
}