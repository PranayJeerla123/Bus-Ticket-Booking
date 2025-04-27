package BusTicket;

import java.sql.*;

public class Register extends Colors {
	static void register() throws Exception {
    	System.out.println(Bold+"Enter name :  "+RESET+Bold+Green);
    	String name=Main.sc.next();
    	
    	System.out.println(RESET+Bold+"Enter phoneNumber :  "+RESET+Bold+Green);
    	String phno=Main.sc.next();
    	System.out.println(RESET+Bold+"Enter password :  "+RESET+Green);
    	String password=Main.sc.next();
    	System.out.print(RESET);
    	String sql="insert into user1(name,phonenumber,password) values(?,?,?)";
    	PreparedStatement ps=Main.con.prepareStatement(sql);
    	ps.setString(1,name);
    	ps.setString(2,phno);
    	ps.setString(3,password);
    	int r=ps.executeUpdate();
    	if(r>0){
    		System.out.println(Bold+Purple+"Successfully Registered"+RESET);
    		System.out.println(Bold+"Enter 1 to Login"+RESET+Bold+Green);
    		String s=Main.sc.next();
    		System.out.print(RESET);
    		if(s.equals("1")) {
    			Login.login();
    		}
        }
}
}
