package com.hotel.HotelManagementSystem;

import java.text.ParseException;
import java.util.Scanner;

import com.hotel.HotelManagementSystem.entity.Booking;
import com.hotel.HotelManagementSystem.entity.Room;
import com.hotel.HotelManagementSystem.exception.BookingNotFound;
import com.hotel.HotelManagementSystem.exception.InvalidBookingId;
import com.hotel.HotelManagementSystem.service.BookingService;
import com.hotel.HotelManagementSystem.service.RoomService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BookingService bservice = new BookingService();
        RoomService rservice = new RoomService();
        Scanner ip = new Scanner(System.in);
        int bid =0;
        String cname=""; 
        String cmobile =""; 
        int guests =0; 
        int nroom =0;
        String troom ="";
        String cidate =""; 
        int ndays =0;
		double advance =0.0;
		char ch = 'Y';
		while(ch == 'Y' ||ch == 'y')
        {
			System.out.println("1. Check In \n 2. Update Booking \n 3. View Records \n 4. Check Out");
			System.out.println("Enter your choice");
			int opt = ip.nextInt();
			switch (opt) {
			case 1:
				System.out.println("Check In");
				System.out.println("Booking Id : ");
				bid = ip.nextInt();
				ip.nextLine();
				System.out.println("Customer Name : ");
				cname= ip.nextLine();
				System.out.println("Mobile No. :");
				cmobile= ip.nextLine();
				System.out.println("Number of Guest : ");
				guests= ip.nextInt();
				System.out.println("Number of Rooms Req. : ");
				nroom= ip.nextInt();
				ip.nextLine();
				
					System.out.println("Choose Type of Room : \n 1. AC \n 2. Non-AC \n Enter Your Choice");
					int k =ip.nextInt();
				switch (k) {
				case 1:
					troom ="AC";
					break;
				case 2:
					troom = "Non-AC";
					break;

				default:
					System.out.println("Choose 1 or 2");
					break;
				}
				ip.nextLine();
				System.out.println("Check In Date(yyyy-MM-dd) : ");
				cidate = ip.nextLine();
				System.out.println("Number of Days : ");
				ndays= ip.nextInt();
				System.out.println("Advance : ");
				advance= ip.nextDouble();
				
				bservice.checkIn(bid, cname, cmobile, guests, nroom, troom, ndays, advance);
				try {
					rservice.checkIn(troom, cname, bid, cidate, ndays, nroom);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Update Booking");
				System.out.println("Booking Id : ");
				bid = ip.nextInt();
				
				System.out.println("Customer Name : ");
				cname= ip.next();
				
				System.out.println("Mobile No. :");
				cmobile= ip.next();
				ip.nextLine();
				System.out.println("Number of Guest : ");
				guests= ip.nextInt();
				System.out.println("Number of Rooms Req. : ");
				nroom= ip.nextInt();
				
				while(troom!="") {
					System.out.println("Choose Type of Room : \n 1. AC \n 2. Non-AC \n Enter Your Choice");
					int k1 =ip.nextInt();
				switch (k1) {
				case 1:
					troom ="AC";
					break;
				case 2:
					troom = "Non-AC";
					break;

				default:
					System.out.println("Choose 1 or 2");
					break;
				}
				}
				System.out.println("Check In Date(yyyy-MM-dd) : ");
				cidate = ip.nextLine();
				System.out.println("Number of Days : ");
				ndays= ip.nextInt();
				System.out.println("Advance : ");
				advance= ip.nextDouble();
				
				bservice.updateBooking(bid, cname, cmobile, guests, nroom, troom, ndays, advance);
				try {
					rservice.updateRoom(troom, cname, bid, cidate, ndays, nroom);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("1. View Booking \n 2. View Rooms \n 3. View All Bookings \n 4. View All Rooms");
				int k2 = ip.nextInt();
				switch (k2) {
				case 1:
					System.out.println("View Booking");
					System.out.println("Enter Booking Id");
					bid = ip.nextInt();
					try {
						System.out.println(bservice.viewBooking(bid));
					} catch (BookingNotFound e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				case 2:
					System.out.println("View Room");
					System.out.println("Enter Booking Id");
					bid = ip.nextInt();
					try {
						System.out.println(rservice.viewRoom(bid));
					} catch (BookingNotFound e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				case 3:
					System.out.println("View All Bookings");
					System.out.println(bservice.viewAllBookings());
					
					break;
				case 4:
					System.out.println("View All Rooms");
					System.out.println(rservice.viewAllRooms());
					
					break;

				default:
					System.out.println("Wrong Choice...");
					break;
				}
				break;
			case 4:
				System.out.println("Check Out");
				System.out.println("Enter Booking Id");
				bid= ip.nextInt();
				try {
					bservice.deleteBooking(bid);
				} catch (InvalidBookingId e) {
					e.printStackTrace();
				}
				try {
					rservice.deleteRoom(bid);
				} catch (InvalidBookingId e) {
					e.printStackTrace();
				}
				break;

			default:
				break;
			}
			System.out.println("Want to Continue??? Press Y: ");
        	ch = ip.next().charAt(0);
        }
		System.out.println("Thank You!!!");
    }
}
