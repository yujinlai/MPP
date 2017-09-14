package ui;

public class CheckOverdueData {
	private String isbn;
    private String bookTitle;
    private String bookNumber;
    private String memberName;
    private String dueDay;
    
    public CheckOverdueData(String isbn, String bookTitle,String bookNumber, String memberName, String dueDay){
    	this.isbn = isbn;
    	this.bookTitle = bookTitle;
    	this.bookNumber = bookNumber;
    	this.memberName = memberName;
    	this.dueDay = dueDay;
 
    }
    
    public String getIsbn() {
        return isbn;
    }
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
    public String getBookNumber() {
        return bookNumber;
    }
	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookTitle() {
        return bookTitle;
    }
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getMemberName() {
        return memberName;
    }
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getDueDay() {
        return dueDay;
    }
	public void setDueDay(String dueDay) {
		this.dueDay = dueDay;
	}
}
