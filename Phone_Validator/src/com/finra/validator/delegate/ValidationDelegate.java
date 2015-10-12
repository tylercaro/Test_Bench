package com.finra.validator.delegate;

import java.util.ArrayList;
import java.util.List;

import com.finra.validator.logic.Validate;

public class ValidationDelegate {

	private Object[][] phoneNo = {{1,2,3,}, {1}, {4,5,6,7}};
	
	/**
	 * Converts numerical phone number into a 2D array with each
	 * 1D element being an array of possible alphanumeric representations
	 * of that digit ( ie. 2 would map to {"A","B","C"})
	 * 
	 * @param phoneNo User input phone number to be converted
	 * @return result returns all alphanumeric combinations of phoneNo
	 * 
	 */
	public ArrayList<String> getValidation (String inputPhoneNo){
		List<String> result = new ArrayList<>();
		Validate combinations = new Validate(phoneNo);
		
		result= combinations.getResult();
		return (ArrayList<String>) result;
	}
	
}
