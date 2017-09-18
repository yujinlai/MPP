package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckOutRecord implements Serializable {

	private static final long serialVersionUID = 6111662638192434968L;
	private String memberID = null;
	
	private ArrayList<CheckoutRecordEntry> entries;
	
	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	public CheckOutRecord(String memberID) {
		setMemberID(memberID);
		entries = new ArrayList<CheckoutRecordEntry>();
	}

	public ArrayList<CheckoutRecordEntry> getCheckOutRecords() {
		return entries;
	}

	public void setCheckOutRecords(ArrayList<CheckoutRecordEntry> entries) {
		this.entries = entries;
	}

	public void addCheckOut(CheckoutRecordEntry entry){
		if(entries == null)
			entries = new ArrayList<>();
		entries.add(entry);
	}

	public List<BookCopy> searchBookCopies(String isbn){
		ArrayList<BookCopy> bookCopies = new ArrayList<>();
		for(CheckoutRecordEntry entry : entries){
			if(entry.getRequestedBook().getBook().getIsbn().equals(isbn))
				bookCopies.add(entry.getRequestedBook());
		}
		return bookCopies;
	}
	
	public List<CheckoutRecordEntry> searchOverdueBookCopies(String isbn){
		ArrayList<CheckoutRecordEntry> recordEntries = new ArrayList<>();
		for(CheckoutRecordEntry entry : entries){
			if(entry.getRequestedBook().getBook().getIsbn().equals(isbn) && 
					entry.isDue())
				recordEntries.add(entry);
		}
		return recordEntries;
	}
}
