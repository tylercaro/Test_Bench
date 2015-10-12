package com.finra.validator.logic;

import java.util.ArrayList;
import java.util.List;

public class Validate {

	private List<String> result = new ArrayList<>();

	/**
	 * Constructor runs through recursion and stores 
	 * values to result ArrayList
	 * 
	 * @param phoneNo the phone number and its alphanumeric values
	 */
	public Validate(Object[][] phoneNo){
		this.mix("", phoneNo, 0);
	}

	/**
	 * Recursively finds all alphanumeric combinations of a given phone number.
	 * 
	 * @param temp stores the mixed phone number during recursion
	 * @param phoneNo the phone number and its alphanumeric values
	 * @param k used to shift which bin the program is looping through
	 */
	public void mix(String temp, Object[][] phoneNo, int bin) {
		// store the mixed number
		if (bin == phoneNo.length) {
			this.result.add(temp);
		} else {
			// loop through a bin
			for (Object val : phoneNo[bin]) {
				// shift to next bin, storing last bin's value
				mix(temp + val, phoneNo, bin + 1);
			}
		}
	}
	
	public List<String> getResult() {
		return result;
	}

}
