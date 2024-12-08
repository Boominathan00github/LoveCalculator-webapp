package com.springmvc.lc.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

	@NotBlank(message = "*yourName not blank")
	@Size(min = 3,message = "*min size above 3 char")
	private String yourName;
	
	@NotBlank(message = "*crushName not blank")
	@Size(min = 3,message = "*min size above 3 char")
	private String crushName;
	
	@AssertTrue(message = "*must be check the box")
	private boolean condition;


	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "UserDto [YourName=" + yourName + ",/n CrushName=" + crushName + "]";
	}



}
