package com;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Driver {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();	
////
//		Engine e = new Engine();
//		e.setCc(1500);
//		e.setType("diesel");
//		
//		Car c= new Car();
//		c.setBrand("Lambo");
//		c.setModel("GT");
//		c.setEngine(e);
//		c.setRegisterDate(LocalDate.now());
//		
//		et.begin();
//		em.persist(e);
//		em.persist(c);
//		et.commit();
//		findByDate(LocalDate.now());
		
		allocateEngine(108,13);
		
	}
	
	public static void findByDate(LocalDate date) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();	
		
		String jpql = "select c from Car c where c.registerDate=?1";
		Query query  = em.createQuery(jpql);
		query.setParameter(1, date);
		List<Car> li = query.getResultList();
		li.forEach(al->System.out.println(al.getId()));
	}
	
//	public static Car findCarById(int id) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();	
//		
//		String jpql = "select c from Car c where c.id=?1";
//		Query query  = em.createQuery(jpql);
//		query.setParameter(1, id);
//		Car car = (Car)query.getSingleResult();
//		return car;
//	}
//	
//	public static void removeEnginebyCarId(int id) {
//		Car car = findCarById(id);
//		Engine e = new Engine();
//		e.setId(NULL);
//		car.setEngine();
//		
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();	
//		
//		String jpql = "update Car c set c.e_id = NULL where c.id=?1";
//		Query query  = em.createQuery(jpql);
//		query.setParameter(1, engineId);
//		
//		et.begin();
//		em.persist(car);
//		et.commit();
//	}
//	
	public static void allocateEngine(int car_id,int engine_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();	
		
//		Not running because c.engine is object reference cant pass in jpql therefore use native query
//		String jpql = "Update car c set c.engine=:e_id where c.id=:c_id";
		String sql = "Update Car set e_id=:e_id where id=:c_id";
		et.begin();
		Query query  = em.createQuery(sql);
		query.setParameter("e_id",engine_id);
		query.setParameter("c_id",car_id);
		int count = query.executeUpdate();
		System.out.println(count);
		et.commit();
	}

}