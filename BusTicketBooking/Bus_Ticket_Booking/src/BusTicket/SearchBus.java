package BusTicket;
import java.util.*;
import java.sql.*;
import bus.*;
public class SearchBus extends Colors{
      static void search(String phone) throws SQLException {
    	  ArrayList<BusObj> al=new ArrayList<>();
    	  System.out.println(Bold+"Enter From : "+RESET+Bold+Green);
    	  String from=Main.sc.next();
    	  System.out.println(RESET+Bold+"Enter To : "+Green);
    	  String to=Main.sc.next();
    	  System.out.println(RESET+Bold+"Enter Date : "+Green);
    	  String date=Main.sc.next();
    	  System.out.print(RESET);
    	  String sql="select * from buses where from1 = '"+from+"' and to1 = '"+to+"' and dat = '"+date+"';";
    	  Statement st=Main.con.createStatement();
      	  ResultSet result=st.executeQuery(sql);
      	  System.out.println(Purple+"---------Avaliable Buses-------"+RESET);
      	  while(result.next()) {
      		String busno=result.getString("busno");
      		String bname=result.getString("busname");
      		String timing=result.getString("timings");
      		int price=result.getInt("price");
      		String date1=result.getString("dat");
      
      		System.out.println(Bold+"---------------------"+Red);
            System.out.println(bname+RESET);
            System.out.println(Bold+Blue+"Timings -> "+Yellow+timing);
            System.out.println(Bold+Blue+"Price -> "+Yellow+price);
            System.out.println(Bold+Blue+"Date -> "+Yellow+date1);
            al.add(new BusObj(busno,bname,timing,price,date1,from,to));
          }
      	  System.out.println(RESET+Bold+"Enter Timings"+Green);
      	  String timing=Main.sc.next();
      	  System.out.println(Purple+"---------Avaliable Seats-------");
      	  int x=1;
      	  for(BusObj obj:al) {
      		  if(obj.gettiming().equals(timing)) {
      			      String t="";
      			      for(int i=0;i<obj.gettiming().length();i++) {
      			    	  if(!(obj.gettiming().charAt(i)=='-')) {
      			    		  t+=obj.gettiming().charAt(i);
      			    	  }
      			    		   
      			      }
      			  for(int i=0;i<7;i++) {
      				  for(int j=0;j<4;j++) {
      					  if(j==2)
      						  System.out.print("  ");
      					  if(x<10 && j!=0 && j!=2)
      						  System.out.print("  ");
      					  if(x==10)
      						  System.out.print(" ");
      					  String sql2="select * from "+obj.getbusno()+t+" where seatno = "+x;
      					  ResultSet result2=st.executeQuery(sql2);
      					  if(result2.next()) {
      						  String confirmed=result2.getString("confirmed");
      						  if(confirmed.equals("NO")) {
      							 System.out.print(Bold+Green+x+RESET+" ");
      						  }
      						  else {
      							  System.out.print(Bold+Red+"x "+RESET);
      						  }
      					  }
      					  x++;
      				  }
      				  System.out.println();
      			  }
      			try {
      				int price=obj.getprice();
      				BookTicket.book(obj,date,phone,price);
      			}
      			catch(Exception e) {
      				System.out.println(e);
      			}
      		  }
      		  
      		  
      	  }
      	  
      	  
}
}
