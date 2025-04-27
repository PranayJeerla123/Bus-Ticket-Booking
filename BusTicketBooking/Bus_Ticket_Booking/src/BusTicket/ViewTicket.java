package BusTicket;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ViewTicket extends Buses{
	 ArrayList<Buses>b=new ArrayList<>();
	public static void view(String phone) throws Exception {
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
		String pn="";
		for(Buses obj:b) {
			String sql="select * from "+obj.bt+" where phonenumber = "+phone;
			ResultSet result=st.executeQuery(sql);
			while(result.next()) {
				int seatno=result.getInt("seatno");
				String pname=result.getString("pname");
				pn=pname;
				String busno=result.getString("busno");
				String gender=result.getString("gender");
				String age=result.getString("age");
				String date=result.getString("dat");
				System.out.println(Colors.RESET+Colors.Bold+"--------------------------------------------");
				System.out.println("|      Destinoo      ");
				System.out.println("|___________________________________________");
				System.out.println("| Bus Number     : "+busno);
				System.out.println("| Bus Name     : "+obj.bname);
				System.out.println("| Seat Number    : "+seatno);
				System.out.println("| Passenger Name :"+pname);
				System.out.println("| Gender         :"+gender);
				System.out.println("| Age            :"+age);
				System.out.println("| Date           :"+date);

				System.out.println("| From        ------------------   To ");
				System.out.println("|         "+obj.from+" -------"+obj.to);
				System.out.println("| Timings        :"+obj.timing);
				System.out.println("| Price          :"+obj.price);
				System.out.println("--------------------------------------------");
			}
		}
		
		System.out.println(Colors.Bold+"Enter one Option : ");
    	System.out.println(Colors.Blue+"1.Go To Back");
    	System.out.println("2.Logout"+Colors.Green);
    	String d=Main.sc.next();
    	System.out.print(Colors.RESET);
    	if(d.equals("1")) {
    		Login.UserHome(pn,phone);
    	}
    	else if(d.equals("2")) {
    		Main.home();
    	}
    	
	}
}
