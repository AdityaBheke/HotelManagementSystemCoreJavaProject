package com.hotel.HotelManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	private int bid;
	private String cname;
	private String cmobile;
	private int guests;
	private int nroom;
	private String troom;
	private int ndays;
	private double advance;
	private double totalAmount;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int bid, String cname, String cmobile, int guests, int nroom, String troom, int ndays,
			double advance, double totalAmount) {
		super();
		this.bid = bid;
		this.cname = cname;
		this.cmobile = cmobile;
		this.guests = guests;
		this.nroom = nroom;
		this.troom = troom;
		this.ndays = ndays;
		this.advance = advance;
		this.totalAmount = totalAmount;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCmobile() {
		return cmobile;
	}
	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}
	public int getGuests() {
		return guests;
	}
	public void setGuests(int guests) {
		this.guests = guests;
	}
	public int getNroom() {
		return nroom;
	}
	public void setNroom(int nroom) {
		this.nroom = nroom;
	}
	public String getTroom() {
		return troom;
	}
	public void setTroom(String troom) {
		this.troom = troom;
	}
	public int getNdays() {
		return ndays;
	}
	public void setNdays(int ndays) {
		this.ndays = ndays;
	}
	public double getAdvance() {
		return advance;
	}
	public void setAdvance(double advance) {
		this.advance = advance;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", cname=" + cname + ", cmobile=" + cmobile + ", guests=" + guests + ", nroom="
				+ nroom + ", troom=" + troom + ", ndays=" + ndays + ", advance=" + advance + ", totalAmount="+totalAmount+" ]";
	}
	

}
