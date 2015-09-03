/*
 *  Write code to find the First non repeated character in the String 
 */

package com.eintern.q1;

import java.util.HashMap;

public class FindRepeating {
	
	public static void main(String[] args) {
		//breaks down with case of letter, but decent solution
		System.out.println(firstNonRepeat("That"));
		System.out.println(firstNonRepeat("oops"));
	}
	public static Character firstNonRepeat(String str){
		
		HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();
		int length = str.length();
		Character c;
		
		for( int index = 0; index<length; index++){
			c = str.charAt(index);
			
			if(characterMap.containsKey(c)){
				characterMap.put(c, characterMap.get(c)+1);
			}else {
				characterMap.put(c,1);
			}
			
		}
		
		for(int index = 0; index<length; index++){
			c= str.charAt(index);
			if(characterMap.get(c).equals(1)){
				return c;
			}
		}
		
		return null;
	}

}
