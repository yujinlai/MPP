package ui;

public class AllBooksData {
    private String isbn;
    private String title;
    private String maxCheckoutLen;
    
    public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMaxCheckoutLen() {
		return maxCheckoutLen;
	}

	public void setMaxCheckoutLen(String maxCheckoutLen) {
		this.maxCheckoutLen = maxCheckoutLen;
	}

	public AllBooksData(String isbn, String title, String maxCheckoutLen){
    	this.isbn = isbn;
    	this.title = title;
    	this.maxCheckoutLen = maxCheckoutLen;

    }
}
