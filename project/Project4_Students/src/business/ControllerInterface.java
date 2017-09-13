package business;

import java.util.HashMap;
import java.util.List;

public interface ControllerInterface {
	//use case 1
	public void login(String id, String password) throws LoginException;

	public List<String> allMemberIds();

	public List<String> allBookIds();

	//use case 2
	public void addLibraryMember(LibraryMember libraryMember);

	//use case 3
	public void checkoutBook(String memberId, String isbn) throws LibrarySystemException;

	//use case 4
	public void addExistingBookCopy(String Isbn);

    //use case 5
	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors, int copyNum);

	//use case 6
	public CheckOutRecord getCheckoutRecord(String memberId);

	//use case 7
	public HashMap<BookCopy, LibraryMember> searchCheckOutBooks(String isbn);

}
