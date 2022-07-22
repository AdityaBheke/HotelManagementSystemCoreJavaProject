package com.hotel.HotelManagementSystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.hotel.HotelManagementSystem.entity.Booking;

public class BookingDao {
	public EntityManager getEM() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel_pu");
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public boolean addBooking(Booking b) {
		EntityManager em = getEM();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		return true;
	}

	public boolean deleteBooking1(Booking b) {
		EntityManager em = getEM();
		em.getTransaction().begin();

		int biid = b.getBid();
		Booking b1 = em.find(Booking.class, biid);
		em.remove(b1);

		em.getTransaction().commit();
		return true;
	}

	public Booking viewBooking(int bid) {
		EntityManager em = getEM();
		em.getTransaction().begin();
		Booking b = em.find(Booking.class, bid);
		em.getTransaction().commit();
		return b;
	}

	public List<Booking> viewAllBookings() {
		EntityManager em = getEM();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT b FROM Booking b");
		List<Booking> blist = query.getResultList();
		em.getTransaction().commit();
		return blist;
	}

}
