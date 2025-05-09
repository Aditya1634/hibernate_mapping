package com;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();	

		Engine e = new Engine();
		e.setCc(1500);
		e.setType("diesel");
		
		Car c= new Car();
		c.setBrand("Ferrari");
		c.setModel("GT");
		c.setEngine(e);
		c.setRegisterDate(LocalDate.of(2025, 4, 12));
		
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
	}

}