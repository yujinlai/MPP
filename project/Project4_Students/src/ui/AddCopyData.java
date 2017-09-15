package ui;

public class AddCopyData {
    private String bookName;
    private String copyNum;
    private String isAvailable;

    public AddCopyData(String bookName, String copyNum, String isAvailable){
    	this.bookName = bookName;
    	this.copyNum = copyNum;
    	this.isAvailable = isAvailable;

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
	public String getIsAvailable() {
        return isAvailable;
    }
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

}
