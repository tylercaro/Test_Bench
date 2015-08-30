package com.eintern.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.eintern.model.Calculation;

@ManagedBean(eager=true)
@ApplicationScoped
public class CalcDao {
	
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
	
	public List<Calculation> getAllCalculations(){
		List<Calculation> result= new ArrayList<Calculation>();
		Session session= sf.openSession();
		Transaction trans = session.getTransaction();
		try {
			trans.begin();
			Query query=session.createQuery("from Calculation order by calcId desc");
			result=(List<Calculation>)query.list();
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
