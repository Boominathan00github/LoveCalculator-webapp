package com.springmvc.lc.service;

import org.springframework.stereotype.Component;

@Component
public class LCAppServiceImpl implements LCAppService {

	public char resultCalculate(String yourName, String curshName) {

	final String NAME = "FLAMES";

		int resultLen = (yourName + curshName).toCharArray().length;

		int result = resultLen % NAME.toCharArray().length;

		return NAME.charAt(result);
	}
	
	

	public String charToString(char result) {

		if (result == 'F')
			return "FRIEND";
		else if (result == 'L')
			return "LOVE";
		else if (result == 'A')
			return "AFFECTION";
		else if (result == 'M')
			return "MARRIAGE";
		else if (result == 'E')
			return "ENEMY";

		return "NONE";
	}

}
