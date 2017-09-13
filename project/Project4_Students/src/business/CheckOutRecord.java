package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckOutRecord implements Serializable {

	private static final long serialVersionUID = 6111662638192434968L;
	private ArrayList<CheckoutRecordEntry> entries = new ArrayList<>();

	public ArrayList<CheckoutRecordEntry> getCheckOutRecords() {
		return entries;
	}

	public void setCheckOutRecords(ArrayList<CheckoutRecordEntry> entries) {
		this.entries = entries;
	}

	public void addCheckOut(CheckoutRecordEntry entry){
		this.entries.add(entry);
	}

	public List<BookCopy> searchBookCopies(String isbn){
		ArrayList<BookCopy> bookCopies = new ArrayList<>();
		for(CheckoutRecordEntry entry : entries){
			if(entry.getRequestedBook().getBook().getIsbn().equals(isbn))
				bookCopies.add(entry.getRequestedBook());
		}
		return bookCopies;
	}
}
