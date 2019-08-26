package com.cni.stock.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cni.stock.model.Commande;
import com.cni.stock.model.Fournisseur;

public class CommandeDAO implements ICommandeDAO {

	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addCommande(Commande commande) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(commande);
		tx.commit();
		session.close();
	}

	@Override
	public void updateCommande(Commande commande) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(commande);
		tx.commit();
		session.close();		
	}

	@Override
	public void deleteCommande(Commande commande) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(commande);
		tx.commit();
		session.close();		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Commande findById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Commande where id=?").setParameter(0, id).list();
		tx.commit();
		session.close();		
		return (Commande)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> findAll() {
		System.out.println("findAll DAO");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Commande> list = session
				.createQuery("from Commande").list();
		tx.commit();
		session.close();		
		return list;
	}

	@Override
	public Commande findCommandeByDateFournisseur(Date jour, Fournisseur fournisseur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Commande where jour = ? and fournisseur = ?")
				.setParameter(0, jour).setParameter(1, fournisseur).list();
		tx.commit();
		session.close();
		if(list.size()==0){
			return null;
		}else{
			return (Commande) list.get(0);
		}		
	}

	@Override
	public Commande findCommandeByDateAjout(Date jour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Commande where jour = ? and type = ?")
				.setParameter(0, jour).setParameter(1, "Ajout").list();
		tx.commit();
		session.close();
		if(list.size()==0){
			return null;
		}else{
			return (Commande) list.get(0);
		}
	}

	@Override
	public Commande findCommandeByDateRetrait(Date jour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List list = session
				.createQuery("from Commande where jour = ? and type = ?")
				.setParameter(0, jour).setParameter(1, "Retrait").list();
		tx.commit();
		session.close();
		if(list.size()==0){
			return null;
		}else{
			return (Commande) list.get(0);
		}
	}

}
