package BusTicket;

import java.sql.*;

public class Login extends Colors{
	public static void UserHome(String name,String phno) throws Exception {
		System.out.println(RESET+Bold+Purple+"*********** Welcome "+name+" **************"+RESET);
		System.out.println(Bold+"Enter any Option"+RESET);
    	System.out.println(Blue+"1.New bookings");
    	System.out.println("2.My bookings"+RESET+Bold+Green);
    	String x=Main.sc.next();
    	System.out.print(RESET);
    	if(x.equals("1")) {
    		SearchBus.search(phno);
    	}
    	else if(x.equals("2")) {
    		ViewTicket.view(phno);
    	}
	}
	public static void login() throws Exception {
		System.out.println(Purple+"********* Login In ********"+RESET);
		System.out.println(Bold+"Enter Phone Number :"+Green);
    	String phno=Main.sc.next();
    	System.out.print(RESET);
    	String sql="select * from user1 where phonenumber = "+phno;
    	Statement st=Main.con.createStatement();
    	ResultSet result=st.executeQuery(sql);
    	if(result.next()) {
    		String name=result.getString("name");
    		String password=result.getString("password");
    		System.out.println(Bold+"Enter Password"+RESET+Bold+Green);
        	String pass=Main.sc.next();
    		if(password.equals(pass)) {
    			UserHome(name,phno);
    		}
    		else {
    			System.out.println(Bold+Red+"Invalid Password"+RESET);
    	        login();
    		}
    	}
    	else {
    		System.out.println(Bold+Red+"Your Not Registered"+RESET);
    		System.out.println(Bold+"Enter 1 to go for Registration");
    		String ss=Main.sc.next();
    		if(ss.equals("1")) {
    			Register.register();
    		}
    	}
    	
    }
}
