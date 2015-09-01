package com.eintern.q1;

public class StringReplace {

	public String removeChar(String s, char c) {
		StringBuffer buf = new StringBuffer(s.length());
		buf.setLength(s.length());
		int current = 0;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur != c) {
				current++;
				buf.setCharAt(current, cur);
			}

		}
		return buf.toString();
	}

	public static void main(String[] args) {
		StringReplace replace = new StringReplace();
		System.out.println(replace.removeChar("Java mustard race.", 'i'));
	}

}
