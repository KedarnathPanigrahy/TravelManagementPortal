package com.kd.microservices.tmp.ns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Service
@Slf4j
public class NotifyService {
	@Autowired
	private JavaMailSender mailSender;

	public void notifyUser(String user, String email) {
		log.info("Started NotifyService - notifyUser");
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("techiekedar90@gmail.com");
//		message.setTo(email);
//		message.setText("Test Text");
//		message.setSubject("Test Body");
//
//		mailSender.send(message);

		String smtpHostServer = "smtp.example.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpHostServer);

		Session session = Session.getInstance(props, null);
		sendEmail(session, email, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");
		log.info("Mail Sent to : " + email);
	}

	public static void sendEmail(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
