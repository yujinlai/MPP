package ui;

public class CheckoutBookData {

    private String bookName;
    private String copyNum;
    private String checkoutDate;
    private String dueDate;
    
    public CheckoutBookData(String bookName, String copyNum, String checkoutDate, String dueDate){
    	this.bookName = bookName;
    	this.copyNum = copyNum;
    	this.checkoutDate = checkoutDate;
    	this.dueDate = dueDate;

    }
    
    public String getBookName() {
        return bookName;
    }
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCopyNum() {
        return copyNum;
    }
	public void setCopyNum(String copyNum) {
		this.copyNum = copyNum;
	}
	public String getCheckoutDate() {
        return checkoutDate;
    }
	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
}
