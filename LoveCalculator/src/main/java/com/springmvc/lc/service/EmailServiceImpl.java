package com.springmvc.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String email, String result,String yourname,String curshname) {

		SimpleMailMessage simplmailmessage = new SimpleMailMessage();
		//simplmailmessage.setFrom("boominathanb218@gmail.com");
		simplmailmessage.setTo(email);
		simplmailmessage.setSubject("This Love Calculate App Result");
		//simplmailmessage.setText("This result prediction by LoveCalculater app "+"Yourname : "+yourname+"CurshName :"+curshname+"\t=\t"+result);
		simplmailmessage.setText("Hi! "+yourname+" The result predicted by the LoveCalculater app is " + result );

		javaMailSender.send(simplmailmessage);

	}

}
