package com.example.demo.utils;

import java.security.SecureRandom;
import java.util.HashMap;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class CustomMailSender {

	@Autowired
	public static JavaMailSender mailSender;

	public static void sendEmail(String email, String subject, String text) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setFrom("wearth2023@gmail.com");
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(text, true);
			mailSender.send(mimeMessage);
		} catch (Exception e) {
			System.out.println("userinfo/isVaildEmail 예외발생: " + e.getMessage());
		}
	}
	
	public static HashMap<String, String> makeCode() {
		HashMap<String, String> mail = new HashMap<>();
		SecureRandom r = new SecureRandom();
		String code = r.nextInt(9000) + 1000 + "";
		String subject = "[Wearth] 이메일 인증코드입니다.";
		String text = "<h2>[Wearth] 위어스 인증코드입니다.</h2>" + "<hr>" + "<h3>인증코드 : " + code + "</h3>";
		mail.put("subject", subject);
		mail.put("text", text);
		mail.put("code", code);
		return mail;
	}
}
