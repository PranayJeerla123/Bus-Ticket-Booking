package BusTicket;
import java.util.*;
import java.sql.*;
public class Main extends Colors{
	public static Scanner sc=new Scanner(System.in);
	public static Connection con;
	public static void home() {
        String ss="__        __   _                            _          ____            _   _             \r\n"
        		+ "\\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___   |  _ \\  ___  ___| |_(_)_ __   ___  \r\n"
        		+ " \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | | | |/ _ \\/ __| __| | '_ \\ / _ \\ \r\n"
        		+ "  \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |_| |  __/\\__ \\ |_| | | | | (_) |\r\n"
        		+ "   \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |____/ \\___||___/\\__|_|_| |_|\\___/ ";
        
        System.out.println(Bold+Red+ss+RESET);
        System.out.println(Bold+"Enter One Option"+RESET);
        System.out.println(Blue+"1.Admin Login");
        System.out.println("2.User Register");
        System.out.println("3.User Login"+RESET);
        System.out.println(Bold+"Enter >> "+RESET+Bold+Green);
        
        String s=sc.next();
        System.out.print(RESET);
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		String url="jdbc:mysql://localhost:3306/bus";
    		con=DriverManager.getConnection(url,"root","12345");
    		if(s.equals("1")) {
    			Admin.adminlogin();
    		}
    		else if(s.equals("2")) {
    	        Register.register();
    	    }
    	    else{
    	        Login.login();
    	    }
        }
        catch(Exception e){
    		throw new RuntimeException("Wrong");
    	}
	}
	public static void main(String[] args) {
		try {
		home();
		}
		catch(Exception e) {
			
		}
	}

}
