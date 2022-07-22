package com.hotel.HotelManagementSystem.service;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

import com.hotel.HotelManagementSystem.exception.BookingNotFound;
import com.hotel.HotelManagementSystem.exception.InvalidBookingId;


public class RoomServiceTest {
	RoomService rservice = new RoomService();
	
	@Test(expected = ParseException.class)
	public void checkInRoomTest() throws ParseException {
		
			rservice.checkIn("AC", "Bheke", 107, "202212-07", 2, 2);
	}
	
	@Test(expected = ParseException.class)
	public void updateRoomTest() throws ParseException {
			rservice.updateRoom("AC", "Bheke", 101, "202212-07", 2, 2);
	}
	
	@Test(expected = BookingNotFound.class)
	public void viewRoomTest() throws BookingNotFound {
			rservice.viewRoom(105);
	}
	
	@Test
	public void viewAllRoomsTest() {
		assertNotNull(rservice.viewAllRooms());
	}
	
	@Test(expected = InvalidBookingId.class)
	public void deleteRoomTest() throws InvalidBookingId {
		rservice.deleteRoom(105);
		}
}
