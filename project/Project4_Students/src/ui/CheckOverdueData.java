package ui;

public class CheckOverdueData {
    private String bookName;
    private String memberName;
    private String dueDay;
    
    public CheckOverdueData(String bookName, String memberName, String dueDay){
    	this.bookName = bookName;
    	this.memberName = memberName;
    	this.dueDay = dueDay;
 
    }
    
    public String getBookName() {
        return bookName;
    }
	public void setBookName(String bookName) {
		this.bookName = bookName;
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
