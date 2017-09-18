package business;

import java.util.HashMap;
import java.util.List;

public interface ControllerInterface {
	//use case 1
	public void login(String id, String password) throws LoginException;

	public List<String> allMemberIds();

	public List<String> allBookIds();
	
	public List<LibraryMember> allLibMembers() ;
	
	public List<Book> allLibBooks();

	//use case 2
	public void addLibraryMember(String userID, String firstName, String lastName, String street, String city, 
			String state, String zipCode, String telephone);

	//use case 3
	public CheckoutRecordEntry checkoutBook(String memberId, String isbn) throws LibrarySystemException;

	//use case 4
	public void addExistingBookCopy(String Isbn);

    //use case 5
	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors, int copyNum);

	//use case 6
	public CheckOutRecord getCheckoutRecord(String memberId);

	//use case 7
	public HashMap<CheckoutRecordEntry, LibraryMember> searchOverDueBooks(String isbn);

}
