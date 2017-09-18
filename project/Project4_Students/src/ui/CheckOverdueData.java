package ui;

public class CheckOverdueData {
	private String isbn;
    private String bookTitle;
    private String copyNumber;
    private String memberID;
    private String dueDay;
    
    public CheckOverdueData(String isbn, String bookTitle,String bookNumber, String memberID, String dueDay){
    	this.isbn = isbn;
    	this.bookTitle = bookTitle;
    	this.copyNumber = bookNumber;
    	this.memberID = memberID;
    	this.dueDay = dueDay;
    }
    
    public String getIsbn() {
        return isbn;
    }
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
    public String getBookNumber() {
        return copyNumber;
    }
	public void setBookNumber(String bookNumber) {
		this.copyNumber = bookNumber;
	}
	public String getBookTitle() {
        return bookTitle;
    }
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getMemberName() {
        return memberID;
    }
	public void setMemberName(String memberName) {
		this.memberID = memberName;
	}
	public String getDueDay() {
        return dueDay;
    }
	public void setDueDay(String dueDay) {
		this.dueDay = dueDay;
	}
}
