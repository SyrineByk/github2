package com.cni.stock.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.LigneCommande;
import com.cni.stock.model.Produit;

public class LigneCommandeDAO implements ILigneCommandeDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addLigneCommande(LigneCommande ligneCommande) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ligneCommande);
		tx.commit();
		session.close();
	}

	@Override
	public void updateLigneCommande(LigneCommande ligneCommande) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(ligneCommande);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteLigneCommande(LigneCommande ligneCommande) {		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(ligneCommande);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public LigneCommande findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from LigneCommande where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (LigneCommande)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommande> findAll() {
		System.out.println("findAll DAO");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<LigneCommande> list = session
				.createQuery("from LigneCommande").list();
		tx.commit();
		session.close();
		System.out.println("size "+list.size());
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommande> findAllAchat() {
		System.out.println("findAll DAO");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<LigneCommande> list = session
				.createQuery("from LigneCommande where commande.type = 'Achat'").list();
		tx.commit();
		session.close();
		System.out.println("size "+list.size());
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommande> findAllAjout() {
		System.out.println("findAll DAO");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<LigneCommande> list = session
				.createQuery("from LigneCommande where commande.type = 'Ajout'").list();
		tx.commit();
		session.close();
		System.out.println("size "+list.size());
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommande> findAllRetrait() {
		System.out.println("findAll DAO");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<LigneCommande> list = session
				.createQuery("from LigneCommande where commande.type = 'Retrait'").list();
		tx.commit();
		session.close();
		System.out.println("size "+list.size());
		return list;
	}

}
