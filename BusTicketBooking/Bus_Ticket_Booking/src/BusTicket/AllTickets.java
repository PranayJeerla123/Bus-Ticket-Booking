package BusTicket;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AllTickets extends Colors{
	public static void tickets() throws Exception {
		ArrayList<Buses>b=new ArrayList<>();
		String sql1="select * from buses";
		Statement st=Main.con.createStatement();
		ResultSet res=st.executeQuery(sql1);
		while(res.next()) {
			String busno=res.getString("busno");
			String busname=res.getString("busname");
			String timing=res.getString("timings");
			int price =res.getInt("price");
			String from=res.getString("from1");
			String to=res.getString("to1");
			String t="";
		    for(int i=0;i<timing.length();i++) {
		    	  if(!(timing.charAt(i)=='-')) {
		    		  t+=timing.charAt(i);
		    	  }
		    		   
		    }
		    b.add(new Buses(busno,busname,timing,price,from,to,busno+t));
		}
		System.out.println(Bold+"-------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("| Bus Number  |    Bus Name    | Bus Timings |    Date    | SeatNumber | Passenger Name | Gender | Age |    From    |    To    |");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------"+RESET);
		for(Buses obj:b) {
			String sql="select * from "+obj.bt;
			ResultSet result=st.executeQuery(sql);
			while(result.next()) {
				String confirmed=result.getString("confirmed");
				int seatno=result.getInt("seatno");
				String pname=result.getString("pname");
				String busno=result.getString("busno");
				String gender=result.getString("gender");
				String age=result.getString("age");
				String date=result.getString("dat");
				if(confirmed.equals("YES")) {
					System.out.print("| "+busno+"       ");
					System.out.print("| "+obj.bname+"      ");
					System.out.print("| "+obj.timing+"  ");
					System.out.print("| "+date+" ");
					System.out.print("|     "+seatno+"     ");
					System.out.print("|     "+pname+"     ");
					System.out.print("|   "+gender+"    ");
					System.out.print("|  "+age+"  ");
					System.out.print("| "+obj.from+" ");
					System.out.println("| "+obj.to+" |");
				}
			}
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
