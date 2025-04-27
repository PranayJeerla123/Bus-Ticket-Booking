package bus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import BusTicket.Colors;
import BusTicket.Login;
import BusTicket.Main;
import BusTicket.ViewTicket;
public class BookTicket extends Colors{
	public static void book(BusObj obj,String date,String phone,int price) throws Exception {
		System.out.println(Bold+"Enter Seat Number : "+Green);
		int seatno=Main.sc.nextInt();
		System.out.println(RESET+Bold+"Enter Passenger Name : "+Green);
		String pname=Main.sc.next();
		System.out.println(RESET+Bold+"Enter Passenger's Gender : "+Green);
		String gender=Main.sc.next();
		System.out.println(RESET+Bold+"Enter Passenger's Age : "+Green);
		int age=Main.sc.nextInt();
		System.out.println(RESET+Bold+Red+"Total Amount :"+price);
		System.out.println(RESET+Bold+"Payment Method");
		System.out.println(Blue+"1.UPI");
		System.out.println("2.Debit Card");
		System.out.println(RESET+Bold+"Enter one Option : "+Green);
		int a=Main.sc.nextInt();
		if(a==1) {
			System.out.println(RESET+Bold+Blue+"1.PhonePay");
			System.out.println("2.GooglePay");
			System.out.println("3.PayTm");
			System.out.println(RESET+Bold+"Enter one Option : "+Green);
			String op=Main.sc.next();
			System.out.println(RESET+Bold+"Enter UPI Id : "+Green);
			String upi=Main.sc.next();
		}
		else {
			System.out.println(RESET+Bold+"Enter Card Number : "+Green);
			String cno=Main.sc.next();
			System.out.println(RESET+Bold+"Enter Card Holder Name : "+Green);
			String cname=Main.sc.next();
			System.out.println(RESET+Bold+"Enter Card Validity : "+Green);
			String cd=Main.sc.next();
			System.out.println(RESET+Bold+"Enter CVV : "+Green);
			String cvv=Main.sc.next();
		}
		System.out.println(RESET+Bold+"Enter one Option :");
		System.out.println(Blue+"1.To make Payment");
		System.out.println(Red+"2.Cancel Payment");
		System.out.println(Yellow+"3.Go to Back"+Green);	
		String  b=Main.sc.next();
		if(b.equals("1")) {
			System.out.println(Cyan+"Processing Your Payment.");
			for(int i=0;i<10;i++) {
      			System.out.print(".");	
      			Thread.sleep(1000);
      		}
			Thread.sleep(3000);
			String t="";
		      for(int i=0;i<obj.gettiming().length();i++) {
		    	  if(!(obj.gettiming().charAt(i)=='-')) {
		    		  t+=obj.gettiming().charAt(i);
		    	  }
		    		   
		      }
		      String y="YES";
			String sql="update "+obj.getbusno()+t+" set pname = '"+pname+"',gender='"+gender+"', age="+age+",confirmed='"+y+"',phonenumber='"+phone+"',dat= '"+date+"' where seatno="+seatno;
			PreparedStatement ps=Main.con.prepareStatement(sql);
			int r=ps.executeUpdate();
	      	if(r>0) {
	      		System.out.println();
	      		System.out.println(Purple+"Your Payment is Successfull........");
	      		System.out.println(RESET+Bold+"Enter 1 to View Your Ticket"+Green);
	      		String op=Main.sc.next();
	      		if(op.equals("1")) {
	      			ViewTicket.view(phone);
	      		}
	      	}
	      	else {
	      		System.out.println(Red+"Your Payment is failed....."+RESET);
	      	}
		}
		else if(b.equals("2")) {
			System.out.println(Red+"Your Payment is Cancelled....."+RESET);
			Login.UserHome(pname,phone);
		}
		else {
			Login.UserHome(pname,phone);
		}
	}
}
