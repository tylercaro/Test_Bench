package com.eintern.jsf.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.eintern.model.User;

@ManagedBean
@SessionScoped
public class UserBean {
	private User user=new User();
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@ManagedProperty(value="#{userDao}")
	private UserDao userdao;

	public UserDao getUserdao() {
		return userdao;
	}


	public String login() {
		String nextPage = "failure";
		User userFromDb= userdao.getUser(user.getUsername());
		if (user.getUsername().equals(userFromDb.getUsername())&& user.getPassword().equals(userFromDb.getPassword())) {
			nextPage = "success?faces-redirect=true";
		}
		return nextPage;
	}
	
	public String register(){
		String nextPage;
		userdao.saveObject(user);
		nextPage="success";
		return nextPage;
	}
}
