package BusTicket;

public class Buses {
	String busno,bname,timing,from,to,bt;
	int price;
	public Buses() {
		
	}
    public Buses(String busno,String bname,String timing,int price,String from,String to,String bt){
    	this.busno=busno;
    	this.bname=bname;
    	this.timing=timing;
    	this.price=price;
    	this.from=from;
    	this.to=to;
    	this.bt=bt;
    }
}
