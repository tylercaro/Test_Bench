package com.eintern.jsf.login;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.eintern.model.User;

@ManagedBean(eager=true)
@ApplicationScoped
public class UserDao {

	
	private SessionFactory sf= HibernateUtil.getSessionFactory();
	
	public void saveObject(Object obj) {
		Session session= sf.openSession();
		Transaction trans = session.getTransaction();
		try {
			trans.begin();
			session.saveOrUpdate(obj);
			trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}
	}
	
	public User getUser(String user){
		Session session= sf.openSession();
		Transaction trans = session.getTransaction();
		User result=new User();
		try {
			trans.begin();
			Query query=session.createQuery("from User where username=:name");
			query.setString("name", user);
			result=(User)query.uniqueResult();
			trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}
		return result;
	}
	
	public List<User> getAllUsers(){
		List<User> result= new ArrayList<User>();
		Session session= sf.openSession();
		Transaction trans = session.getTransaction();
		try {
			trans.begin();
			Query query=session.createQuery("from User");
			result=(List<User>)query.list();
			trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}
		
		return result;
	}


}
