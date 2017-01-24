package main.java.pojo;

public final class  Vendor {
	
	private final String venid;
	private final String venname;
	
	public Vendor(String venid, String venname) {
		super();
		this.venid = venid;
		this.venname = venname;
	}

	public String getVenid() {
		return venid;
	}

	public String getVenname() {
		return venname;
	}
	
	

}
