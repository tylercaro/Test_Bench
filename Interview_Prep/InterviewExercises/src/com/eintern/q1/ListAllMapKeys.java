package com.eintern.q1;

import java.util.HashMap;
import java.util.Set;

public class ListAllMapKeys {
	public static void main(String[] args) {
		HashMap <String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		
		Set<String> mapset = map.keySet();
		for(String key : mapset){
			System.out.println(key);
		}
	}

}
