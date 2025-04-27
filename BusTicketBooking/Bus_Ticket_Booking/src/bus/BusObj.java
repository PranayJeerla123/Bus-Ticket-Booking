package bus;

public class BusObj {
	private String busno,bname,timing,dat,from,to;
	private int price;
	public int seats[][]=new int[7][4];
    public BusObj(String busno,String bname,String timing,int price,String dat,String from,String to){
    	this.busno=busno;
    	this.bname=bname;
    	this.timing=timing;
    	this.price=price;
    	this.dat=dat;
    	this.from=from;
    	this.to=to;
    }
    public String getbusno() {
    	return  busno;
    }
    public String getbname() {
    	return  bname;
    }
    public String gettiming() {
    	return  timing;
    }
    public int getprice() {
    	return  price;
    }
    public String getdat() {
    	return  dat;
    }
    public String getfrom() {
    	return  from;
    } 
    public String getto() {
    	return  to;
    }
}
