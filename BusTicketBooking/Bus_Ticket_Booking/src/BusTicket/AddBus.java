package BusTicket;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class AddBus extends Colors{
	static void add() throws Exception {
		System.out.println(Bold+"Enter Bus Number : "+Green);
		String busno=Main.sc.next();
		System.out.println(RESET+Bold+"Enter Bus Name : "+Green);
		String bname=Main.sc.next();
		System.out.println(RESET+Bold+"Enter Timings : "+Green);
		String timings=Main.sc.next();
		System.out.println(RESET+Bold+"Enter price : "+Green);
		int price=Main.sc.nextInt();
		System.out.println(RESET+Bold+"Enter Date : "+Green);
		String date=Main.sc.next();
		System.out.println(RESET+Bold+"Enter From : "+Green);
		String from=Main.sc.next();
		System.out.println(RESET+Bold+"Enter To : "+Green);
		String to=Main.sc.next();
		String sql="insert into buses(busno,busname,timings,price,dat,from1,to1) values(?,?,?,?,?,?,?)";
    	PreparedStatement ps=Main.con.prepareStatement(sql);
    	ps.setString(1,busno);
    	ps.setString(2,bname);
    	ps.setString(3,timings);
    	ps.setInt(4,price);
    	ps.setString(5,date);
    	ps.setString(6,from);
    	ps.setString(7,to);
    	int r=ps.executeUpdate();
    	if(r>0){
    		System.out.println(Purple+"Successfully Registered Bus"+RESET);
    		String t="";
		    for(int i=0;i<timings.length();i++) {
		    	  if(!(timings.charAt(i)=='-')) {
		    		  t+=timings.charAt(i);
		    	  }
		    		   
		    }
    		String sql2="create table "+busno+t+"(seatno int primary key,busno varchar(20), pname varchar(30),gender varchar(1) ,age int,confirmed varchar(20) default 'NO',phonenumber varchar(20),dat date);";
    		Statement st=Main.con.createStatement();
    		st.execute(sql2);
    		for(int i=1;i<=28;i++) {
    			String sql3="insert into "+busno+t+"(seatno,busno,confirmed) values("+i+",'"+busno+"','NO')";
    			PreparedStatement ps2=Main.con.prepareStatement(sql3);
    			int r2=ps2.executeUpdate();
    		}
        }
    	else {
    		System.out.print(Bold+Red+"Something Went Wrong "+RESET);   
    	}
    	System.out.println(Bold+"Enter one Option : ");
    	System.out.println(Blue+"1.Go To Back");
    	System.out.println("2.Logout"+Green);
    	String d=Main.sc.next();
    	System.out.print(RESET);
    	if(d.equals("1")) {
    		Admin.AdminHome();
    	}
    	else if(d.equals("2")) {
    		Main.home();
    	}
	}
}
