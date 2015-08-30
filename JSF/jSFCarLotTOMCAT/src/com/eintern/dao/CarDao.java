package com.eintern.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.eintern.model.Car;

@ManagedBean(eager = true)
@ApplicationScoped
public class CarDao {

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public void saveObject(Object obj) {
		Session session = sf.openSession();
		Transaction trans = session.getTransaction();
		try {
			trans.begin();
			session.saveOrUpdate(obj);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			session.close();
		}
	}

	public List<Car> getAllCars() {
		List<Car> result = new ArrayList<Car>();
		Session session = sf.openSession();
		Transaction trans = session.getTransaction();
		try {
			trans.begin();
			Query query = session.createQuery("from Car order by carId");
			result = (List<Car>) query.list();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	public List<Car> getByMake(String make) {
		List<Car> result = new ArrayList<Car>();
		Session session = sf.openSession();
		Transaction trans = session.getTransaction();
		try {
			trans.begin();
			Query query = session.createQuery("from Car where make = :chooseMake");
			query.setString("chooseMake", make);
			result = (List<Car>) query.list();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			session.close();
		}

		return result;

	}

}
