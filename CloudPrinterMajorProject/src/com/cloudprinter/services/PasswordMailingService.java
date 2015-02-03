package com.cloudprinter.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PasswordMailingService {

	public boolean sendMail(String emailId, String loginId, String password) {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = "Welcome to Cloud Printer Hmritm....\n"
				+ "Your Login Id & Password is :\n" + loginId + "\n"
				+ password;

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("cloudprinthmr@gmail.com",
					"Cloud Printer Hmritm"));

			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					emailId));
			msg.setSubject("Login Information");
			msg.setText(msgBody);
			Transport.send(msg);

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
		return true;

	}
}
