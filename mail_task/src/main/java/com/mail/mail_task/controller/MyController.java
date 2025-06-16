package com.mail.mail_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MyController {
	
	@Autowired
	JavaMailSender mailSender;
	
	@GetMapping("/") 
		public String load() {
			return "index.html";
		}
	
	@PostMapping("/send")
	@ResponseBody
		public String send(@RequestParam String email, @RequestParam String message) {
		
		SimpleMailMessage message2 = new SimpleMailMessage();
		message2.setTo(email);
		message2.setText(message);
		message2.setSubject("just texting");
		mailSender.send(message2);
		return "message sent sucessfull";
	}
}

	
