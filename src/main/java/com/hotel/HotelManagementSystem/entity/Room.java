package com.hotel.HotelManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
	@Id
	private int rno;
	private String troom;
	private String cname;
	private int bid;
	private String cidate;
	private String codate;
	public Room() {
		super();
	}
	public Room(int rno, String troom, String cname, int bid, String cidate, String codate) {
		super();
		this.rno = rno;
		this.troom = troom;
		this.cname = cname;
		this.bid = bid;
		this.cidate = cidate;
		this.codate = codate;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getTroom() {
		return troom;
	}
	public void setTroom(String troom) {
		this.troom = troom;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getCidate() {
		return cidate;
	}
	public void setCidate(String cidate) {
		this.cidate = cidate;
	}
	public String getCodate() {
		return codate;
	}
	public void setCodate(String codate) {
		this.codate = codate;
	}
	@Override
	public String toString() {
		return "Room [rno=" + rno + ", troom=" + troom + ", cname=" + cname + ", bid=" + bid + ", cidate=" + cidate
				+ ", codate=" + codate + "]";
	}
	
	

}
