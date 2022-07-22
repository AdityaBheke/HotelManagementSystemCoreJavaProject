package com.hotel.HotelManagementSystem.service;

import java.util.ArrayList;

import com.hotel.HotelManagementSystem.dao.BookingDao;
import com.hotel.HotelManagementSystem.entity.Booking;
import com.hotel.HotelManagementSystem.exception.BookingNotFound;
import com.hotel.HotelManagementSystem.exception.InvalidBookingId;

public class BookingService {
	private BookingDao brepo = new BookingDao();

	public String checkIn(int bid, String cname, String cmobile, int guests, int nroom, String troom, int ndays,
			double advance) {
		Double rooms = Double.valueOf(nroom);
		Double days = Double.valueOf(ndays);
		double totalAmount = 2000.0 * rooms * days;
		if (troom.equals("AC")) {
			totalAmount = 2.0 * totalAmount;
		}
		Booking b = new Booking(bid, cname, cmobile, guests, nroom, troom, ndays, advance, totalAmount);
		brepo.addBooking(b);
		return "Added";
	}

	public String updateBooking(int bid, String cname, String cmobile, int guests, int nroom, String troom, int ndays,
			double advance) {
		Double rooms = Double.valueOf(nroom);
		Double days = Double.valueOf(ndays);
		double totalAmount = 2000.0 * rooms * days;
		if (troom.equals("AC")) {
			totalAmount = 2.0 * totalAmount;
		}
		Booking b1 = new Booking(bid, cname, cmobile, guests, nroom, troom, ndays, advance, totalAmount);
		Booking b = brepo.viewBooking(bid);
		if (b != null) {
			brepo.deleteBooking1(b);
		}
		brepo.addBooking(b1);
		return "Updated";
	}

	public Booking viewBooking(int bid) throws BookingNotFound {
		Booking b = brepo.viewBooking(bid);

		if (b != null) {
			return b;
		} else {
			throw new BookingNotFound();
		}
	}

	public ArrayList<Booking> viewAllBookings() {
		return (ArrayList<Booking>) brepo.viewAllBookings();
	}

	public String deleteBooking(int bid) throws InvalidBookingId {
		Booking b = brepo.viewBooking(bid);
		if (b != null) {

			brepo.deleteBooking1(b);

			return "Deleted";
		} else {
			throw new InvalidBookingId();
		}

	}
}
