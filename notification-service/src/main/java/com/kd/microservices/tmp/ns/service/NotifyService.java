package com.kd.microservices.tmp.ns.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotifyService {

	public void notifyUser(String user, String email) {
		log.info("Started NotifyService - notifyUser");
		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("test@gmail.com", "oecjzzaajbjfbbbi");
				}
			});
			
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("test@gmail.com", false));

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			msg.setSubject("Sample Email");
			msg.setContent("Hey "+ user + ", this is the sample email.", "text/html");
			msg.setSentDate(new Date());

//			MimeBodyPart messageBodyPart = new MimeBodyPart();
//			messageBodyPart.setContent("SimpleEmail", "text/html");
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart);
//			MimeBodyPart attachPart = new MimeBodyPart();
//			attachPart.attachFile("/var/tmp/image19.png");
//			multipart.addBodyPart(attachPart);
//			msg.setContent(multipart);
			
			Transport.send(msg);
			log.info("Mail Sent to : " + email);
		} catch (Exception e) {
			log.error("Error at NotifyService - notifyUser : " + e.getMessage());
		}
	}
}
