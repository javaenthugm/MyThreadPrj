package main.java.pojo;

public final class Invoice {

	private final long invId;
	private final long invAmount;

	public Invoice(long invid, long invamout) {
		invId = invid;
		invAmount = invamout;
	}

	public final long getInvId() {
		return invId;
	}

	public final long getInvAmount() {
		return invAmount;
	}

	@Override
	public String toString() {
		return "Invoice [invId=" + invId + ", invAmount=" + invAmount + "]";
	}
	
	
	

}
