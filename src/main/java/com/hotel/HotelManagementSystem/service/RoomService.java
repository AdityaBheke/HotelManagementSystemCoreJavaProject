package com.hotel.HotelManagementSystem.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hotel.HotelManagementSystem.dao.RoomDao;
import com.hotel.HotelManagementSystem.entity.Room;
import com.hotel.HotelManagementSystem.exception.BookingNotFound;
import com.hotel.HotelManagementSystem.exception.InvalidBookingId;

public class RoomService {
	private RoomDao rrepo = new RoomDao();
	
	public String checkIn(String troom, String cname, int bid, String cidate, int ndays, int nroom)
			throws ParseException {
		Calendar cal = Calendar.getInstance();
		String sDate = cidate;
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
		cal.setTime(date);
		cal.add(Calendar.DATE, ndays);
		Date newDate = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String codate = dateFormat.format(newDate);
		String cidate1 = dateFormat.format(date);
		int rno = 101;
		List<Room> eroom = rrepo.viewRoomById(bid);
		if(eroom.size()>0) {
			System.out.println("Bid Already exists");			
			updateRoom(troom, cname, bid, cidate, ndays, nroom);			
		}else {
		List<Room> r1 = rrepo.viewAllRooms();
		if (r1.size() != 0) {
			Room r2 = r1.get(r1.size() - 1);
			rno = r2.getRno();
			rno++;
		}
		for (int i = 1; i <= nroom; i++) {
			Room r = new Room(rno, troom, cname, bid, cidate1, codate);
			rrepo.addRoom(r);
			rno++;
		}}
		return "Added";
	}
	
	public String updateRoom(String troom, String cname, int bid, String cidate, int ndays, int nroom)
			throws ParseException {

		List<Room> croom = rrepo.viewRoomById(bid);
		if (croom.size() > 0) {
			if (nroom < croom.size()) {
				Room rd = croom.get(croom.size() - 1);
				int reduceroom = rd.getRno();

				for (int i = croom.size(); i > nroom; i--) {
					Room nrs = rrepo.viewRoom(reduceroom);
					rrepo.deleteRoom(nrs);
					reduceroom--;
				}
			} else if (nroom > croom.size()) {
				Room rd = croom.get(croom.size() - 1);
				int reduceroom = rd.getRno();
				reduceroom++;
				Calendar cal = Calendar.getInstance();
				String sDate = cidate;
				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
				cal.setTime(date1);
				cal.add(Calendar.DATE, ndays);
				Date newDate = cal.getTime();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String codate = dateFormat.format(newDate);
				String cidate1 = dateFormat.format(date1);
				for (int i = croom.size(); i < nroom; i++) {

					Room nrs = new Room(reduceroom, troom, cname, bid, cidate1, codate);
					rrepo.addRoom(nrs);
					reduceroom++;
				}
			}
			Calendar cal = Calendar.getInstance();
			String sDate = cidate;
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
			cal.setTime(date1);
			cal.add(Calendar.DATE, ndays);
			Date newDate = cal.getTime();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String codate = dateFormat.format(newDate);
			String cidate1 = dateFormat.format(date1);
			Room b = croom.get(0);
			int rno1 = b.getRno();
			for (int i = 0; i < nroom; i++) {
				Room r1 = rrepo.viewRoom(rno1);
				r1.setBid(bid);
				r1.setCidate(cidate1);
				r1.setCname(cname);
				r1.setCodate(codate);
				r1.setTroom(troom);
				rno1++;
			}
		} else {
			checkIn(troom, cname, bid, cidate, ndays, nroom);
		}
		return "Updated";
	}
	
	public List<Room> viewRoom(int bid) throws BookingNotFound {
		List<Room> rlist = rrepo.viewRoomById(bid);
		if (rlist.size() > 0) {
			return rlist;
		} else {
			throw new BookingNotFound();
		}
	}
	
	public ArrayList<Room> viewAllRooms() {

		return (ArrayList<Room>) rrepo.viewAllRooms();
	}
	
	public String deleteRoom(int bid) throws InvalidBookingId {
		List<Room> croom = rrepo.viewRoomById(bid);
		if (croom.size() > 0) {
			Room b = croom.get(0);
			int rno1 = b.getRno();
			for (int i = 0; i < croom.size(); i++) {
				Room r = rrepo.viewRoom(rno1);
				rrepo.deleteRoom(r);
				rno1++;
			}
			return "Deleted";
		} else {
			throw new InvalidBookingId();
		}

	}

}
