package com.springmvc.lc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.springmvc.lc.dto.ContactDto;
import com.springmvc.lc.dto.UserDto;
import com.springmvc.lc.service.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	
	@RequestMapping("/email")
	public String getEmail(@SessionAttribute("userdto") UserDto userdto,Model model,ContactDto email) {
		
		//System.out.println("----->"+email.getEmail());
		//get the Session data and set into the model get userdto.yourName in getEmail.jsp 
		model.addAttribute("email", email);
		model.addAttribute("name", userdto);
		
		return "getEmail";
	}
	
	
	@RequestMapping("/validateemail")
	public String validateEmail(@SessionAttribute("userdto") UserDto userdto,@SessionAttribute("appresult") String appresult, Model model,@Valid ContactDto email,BindingResult result) {
		
		System.out.println("----->"+email.getEmail());
		System.out.println("----->"+appresult);
		model.addAttribute("email", email.getEmail());
		model.addAttribute("name", userdto);
		//model.addAttribute("appresult", appresult);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX+"email", result);
		
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError error : allErrors) {
				System.out.println("Error Occur -->:" + error);
			}
			return "getEmail";
		}
		
		try {
		emailService.sendEmail(email.getEmail(), appresult, userdto.getYourName() , userdto.getCrushName());
		}catch(Exception e) {
			
			System.out.println("While sending email error occur!!!  " + e.getMessage());
			return "getEmail '+' While sending email error occur!!!";
			
		}
		
		return "valideEmail";
	}
}
