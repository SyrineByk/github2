package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Parametre;

public class ParametreDAO implements IParametreDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addParametre(Parametre parametre) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(parametre);
		tx.commit();
		session.close();
	}

	@Override
	public void updateParametre(Parametre parametre) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(parametre);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteParametre(Parametre parametre) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(parametre);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Parametre findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Parametre where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (Parametre)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parametre> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Parametre> list = session
				.createQuery("from Parametre").list();
		tx.commit();
		session.close();		
		return list;
	}

}
