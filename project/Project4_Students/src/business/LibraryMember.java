package business;

import java.io.Serializable;

final public class LibraryMember extends Person implements Serializable {
	private String memberId;

	private CheckOutRecord checkoutRecord = new CheckOutRecord(memberId);

	public CheckOutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckOutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}

	public LibraryMember(String memberId, String fname, String lname, String tel,Address add) {
		super(fname,lname, tel, add);
		this.memberId = memberId;
	}


	public String getMemberId() {
		return memberId;
	}



	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() +
				", " + getTelephone() + " " + getAddress();
	}

	private static final long serialVersionUID = -2226197306790714013L;

	public void addCheckoutBook(CheckoutRecordEntry entry){
		if(checkoutRecord == null)
			checkoutRecord = new CheckOutRecord(memberId);
		checkoutRecord.addCheckOut(entry);
	}
}

