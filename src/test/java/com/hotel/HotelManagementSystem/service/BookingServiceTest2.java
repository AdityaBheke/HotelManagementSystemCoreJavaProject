package com.hotel.HotelManagementSystem.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hotel.HotelManagementSystem.exception.BookingNotFound;
import com.hotel.HotelManagementSystem.exception.InvalidBookingId;

public class BookingServiceTest2 {

	BookingService bservice = new BookingService();
	RoomService rservice = new RoomService();
	@Test
	public void checkInTest() {
		assertEquals("Added",bservice.checkIn(108, "Bheke", "99999999999", 2, 2, "AC", 3, 3000.0));
	}
		
	@Test
	public void UpdateBookingTest() {
		assertEquals("Updated",bservice.updateBooking(101, "Bheke", "99999999999", 2, 2, "AC", 3, 3000.0));
	}
	
	@Test(expected = BookingNotFound.class)
	public void viewBookingTest() throws BookingNotFound {
			bservice.viewBooking(105);
		
	}
	
	@Test
	public void viewAllBookingTest() {
		assertNotNull(bservice.viewAllBookings());
	}
	
	@Test(expected = InvalidBookingId.class)
	public void deleteBookingTest() throws InvalidBookingId {
		
			bservice.deleteBooking(109);
		
	}

}
