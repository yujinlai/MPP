package ui;

public class AddBookCopyData {

	private String bookName;
	private String copyNum;
	private String available;
	
	public AddBookCopyData(String bookName, String copyNum, String available) {
		this.bookName = bookName;
		this.copyNum = copyNum;
		this.available = available;
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
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
}
