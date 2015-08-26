package com.eintern.jsf.login;

import com.eintern.model.User;

public class Testing {
	public static void main(String[] args) {
		
		User testUser = new User();
		UserDao dao = new UserDao();
		testUser.setUsername("Tom");
		testUser.setPassword("1234");
		dao.saveObject(testUser);
	}
}
