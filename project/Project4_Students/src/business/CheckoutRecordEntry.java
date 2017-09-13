package business;

import java.io.Serializable;
import java.util.Date;

public class CheckoutRecordEntry implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 5746422661395039843L;
	BookCopy requestedBook;
	Date checkoutDate;
	Date dueDate;

	public CheckoutRecordEntry(BookCopy requestedBook, Date checkoutDate, Date dueDate) {
		this.requestedBook = requestedBook;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	public BookCopy getRequestedBook() {
		return requestedBook;
	}
	public void setRequestedBook(BookCopy requestedBook) {
		this.requestedBook = requestedBook;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isDue(){
		Date currentDate = new Date();
		return currentDate.after(dueDate);
	}
}

