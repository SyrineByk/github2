package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Type;

public class TypeDAO implements ITypeDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addType(Type type) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(type);
		tx.commit();
		session.close();		
	}

	@Override
	public void updateType(Type type) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(type);
		tx.commit();
		session.close();		
	}

	@Override
	public void deleteType(Type type) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(type);
		tx.commit();
		session.close();		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Type findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Type where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (Type)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Type> list = session
				.createQuery("from Type").list();
		tx.commit();
		session.close();		
		return list;
	}

}
