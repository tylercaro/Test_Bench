package com.eintern.jsf.login;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.eintern.model.User;

@ManagedBean
@SessionScoped
public class UserBean {
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@ManagedProperty(value = "#{userDao}")
	private UserDao userdao;

	public UserDao getUserdao() {
		return userdao;
	}

	public String login() {
		String nextPage = "";
		User userFromDb = userdao.getUser(user.getUsername());
		if (user.getUsername().equals(userFromDb.getUsername())
				&& user.getPassword().equals(userFromDb.getPassword())) {
			nextPage = "success?faces-redirect=true";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("invalid login credentials"));
		}
		return nextPage;
	}

	public String register() {
		String nextPage="";
		if (userdao.getUser(user.getUsername()) != null) {
			//get the current instance of FacesContext that is associated with this request and add error msg
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("user already exists"));
		}

		else {
		
			userdao.saveObject(user);
		}
		//if no messages/errors exist, forward to next page
		if(FacesContext.getCurrentInstance().getMessageList().isEmpty()){
			nextPage = "success";
		}
		return nextPage;
	}
}
