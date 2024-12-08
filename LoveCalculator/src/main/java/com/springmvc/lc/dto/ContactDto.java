package com.springmvc.lc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern.Flag;

public class ContactDto {

	@Email(flags = Flag.UNIX_LINES,message = "*please enter valid email")
	private String email;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
