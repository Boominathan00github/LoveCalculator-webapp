package com.springmvc.lc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.lc.dto.UserDto;
import com.springmvc.lc.service.LCAppService;

@Controller
@SessionAttributes({"userdto","appresult"})
public class LcAppController {
	
	@Autowired
    private LCAppService lcAppService;

	@ResponseBody
	@RequestMapping("/greet")
	public String greet() {

		return "Greeting!!!";
	}

	@RequestMapping("/userinfo")
	public String getUserInfo(Model model, UserDto userdto) {

		model.addAttribute("userdto", userdto);

		return "userInfo";
	}

	@RequestMapping("/Validateuserinfo")
	public String ValidateUserInfo(Model model,@Valid UserDto userdto, BindingResult result) {

    	model.addAttribute("userdto", userdto);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "userdto", result);
		
		//Log the User Enter Yourname & Crushname
		System.out.println("---->"+userdto.getYourName());
		System.out.println("---->"+userdto.getCrushName());
		
		//Catch the Errors And print 
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError error : allErrors) {
				System.out.println("Error Occur -->:" + error);
			}
			//request redirect to userinfo.jsp with error Message
			return "userInfo";
		}
		
		
		//System.out.println("This Is My Validation Result" + userdto.isCondition());
		//resultCalculater calculateResult = new resultCalculater();
		char resultCalculate = lcAppService.resultCalculate(userdto.getYourName(), userdto.getCrushName());
		
		//the appresult get & set vaues also in  Session and get the data other Controller(emailContoller) 
		 model.addAttribute("appresult", lcAppService.charToString(resultCalculate));
		

		 //the bean Validation is pass the request goto ValidateuserInfo.jsp
		return "ValidateuserInfo";
	}

}
