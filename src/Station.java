//Station class for Data access and storage in an array List
public class Station {
	
	String due;
	String des;
	String status;
	String lastLoc;
	String dir;
	String stat;
	
	public Station(){}
	
	public void setStation(String sta, String d, String ds, String s, String ll, String di){
		this.stat = sta;
		this.due = d;
		this.des = ds;
		this.status = s;
		this.lastLoc = ll;
		this.dir = di;
	}
	
	public String getDue() {
		return due;
	}

	public String getDes() {
		return des;
	}

	public String getStatus() {
		return status;
	}

	public String getLastLoc() {
		return lastLoc;
	}

	public String getDir() {
		return dir;
	}
	
	public String getSta(){
		return stat;
	}

}

