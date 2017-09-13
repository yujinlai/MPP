package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import business.Book;
import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;

	//use case 1
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
	}

	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}

	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}

	@Override
	//use case 2
	public void addLibraryMember(LibraryMember libraryMember){
		DataAccess da = new DataAccessFacade();
		da.saveNewMember(libraryMember);
	}

	@SuppressWarnings("deprecation")
	@Override
	//use case 3
	public void checkoutBook(String memberId, String isbn) throws LibrarySystemException{
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> membersMap = da.readMemberMap();
		if(!membersMap.containsKey(memberId)) {
			throw new LibrarySystemException("Member " + memberId + " not found");
		}
		HashMap<String, Book> booksMap = da.readBooksMap();
		if(!booksMap.containsKey(isbn)) {
			throw new LibrarySystemException("ISBN " + isbn + " not found");
		}
		BookCopy bookCopy = booksMap.get(isbn).getNextAvailableCopy();
		if(bookCopy == null){
			throw new LibrarySystemException("The book with ISBN " + isbn + " is not available now");
		}
		bookCopy.changeAvailability();
		Date currentDate = new Date();
		int day = currentDate.getDate() + booksMap.get(isbn).getMaxCheckoutLength();
		Date expireDate = new Date(currentDate.getYear(), currentDate.getMonth(), day);
		membersMap.get(memberId).addCheckoutBook(new CheckoutRecordEntry(bookCopy,
				new Date(), expireDate));
		booksMap.get(isbn).updateCopies(bookCopy);
	}

	@Override
	//use case 4
	public void addExistingBookCopy(String isbn){
		DataAccess da = new DataAccessFacade();
		da.addBookCopy(isbn);
	}

	@Override
	//use case 5
	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors, int copyNum) {
		DataAccess da = new DataAccessFacade();
		Book book = new Book(isbn, title, maxCheckoutLength, authors);
		for(int num = 0; num < copyNum; num ++){
			book.addCopy();
		}
		da.saveNewBook(book);
	}

	@Override
	//use case 6
	public CheckOutRecord getCheckoutRecord(String memberId) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> membersMap = da.readMemberMap();
		LibraryMember libMember = membersMap.get(memberId);
		return libMember.getCheckoutRecord();
	}

	@Override
	//use case 7
	//The method judges whether the book is overdue is in the BookCopy Class itself
	public HashMap<BookCopy, LibraryMember> searchCheckOutBooks(String isbn) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> membersMap = da.readMemberMap();
		HashMap<BookCopy, LibraryMember> bookLibMaps = new HashMap<>();
        for(LibraryMember lib : membersMap.values()){
        	CheckOutRecord checkOut = lib.getCheckoutRecord();
        	List<BookCopy> searchBookCopies = checkOut.searchBookCopies(isbn);
        	for(BookCopy bookCopy: searchBookCopies){
        		bookLibMaps.put(bookCopy, lib);
        	}
        }
		return bookLibMaps;
	}
}