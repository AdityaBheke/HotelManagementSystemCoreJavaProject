package com.hotel.HotelManagementSystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.hotel.HotelManagementSystem.entity.Booking;
import com.hotel.HotelManagementSystem.entity.Room;

public class RoomDao {
	public EntityManager getEM() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel_pu");
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	public boolean addRoom(Room r) {
		EntityManager em = getEM();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		return true;
	}
	
	public boolean deleteRoom(Room r) {
		EntityManager em = getEM();
		em.getTransaction().begin();
		
		int rnoo = r.getRno();
		Room r1 = em.find(Room.class, rnoo);
		em.remove(r1);
		
		em.getTransaction().commit();
		return true;
	}
	
	public List<Room> viewAllRooms(){
		EntityManager em = getEM();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT r FROM Room r");
		List<Room> rlist = query.getResultList();
		em.getTransaction().commit();
		return rlist;
	}
	
	public List<Room> viewRoomById(int bid){
		EntityManager em = getEM();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT r FROM Room r WHERE r.bid = "+bid);
		List<Room> rlist = query.getResultList();
		em.getTransaction().commit();
		return rlist;
	}
	
	public Room viewRoom(int rno) {
		EntityManager em = getEM();
		em.getTransaction().begin();
		Room r = em.find(Room.class, rno);
		em.getTransaction().commit();
		return r;
	}

}
