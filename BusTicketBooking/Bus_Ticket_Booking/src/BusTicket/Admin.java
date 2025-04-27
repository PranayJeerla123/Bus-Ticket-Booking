package BusTicket;

import java.sql.*;

public class Admin extends Colors{
	static void AdminHome() throws Exception {
		System.out.println(Purple+"******* Welcome Admin *******");
		System.out.println(RESET+Bold+"Enter any Option");
    	System.out.println(Blue+"1.Add Buses");
    	System.out.println("2.View Booked Tickets"+Green);
    	String a=Main.sc.next();
    	System.out.print(RESET);
    	if(a.equals("1")) {
    		AddBus.add();
    	}
    	else if(a.equals("2")) {
    		AllTickets.tickets();
    	}
	}
	static void adminlogin() throws Exception {
		System.out.println(Bold+"Enter Admin Login ID: "+Green);
		String loginid=Main.sc.next();
		String sql="select * from admin where phonenumber = "+loginid;
		Statement st=Main.con.createStatement();
    	ResultSet result=st.executeQuery(sql);
    	if(result.next()) {
    		String password=result.getString("password");
    		System.out.println(RESET+Bold+"Enter Password"+Green);
        	String pass=Main.sc.next();
    		if(password.equals(pass)) {
    			AdminHome();
    		}
    		else {
    			System.out.println(Bold+Red+"Invalid Password"+RESET);
    		}
    	}
    	else {
    		System.out.println(Bold+Red+"Your are not admin"+RESET);
    	}
	}
}
