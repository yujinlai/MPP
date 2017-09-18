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
	public static String logName = null;
	
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
		logName = id;
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
	public List<LibraryMember> allLibMembers() {
		DataAccess da = new DataAccessFacade();
		List<LibraryMember> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().values());
		return retval;
		
	}

	@Override
	public List<Book> allLibBooks() {
		DataAccess da = new DataAccessFacade();
		List<Book> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().values());
		return retval;
	}
	
	@Override
	//use case 2
	public void addLibraryMember(String userID, String firstName, String lastName, String street, String city, 
			String state, String zipCode, String telephone) {
		LibraryMember libraryMember = new LibraryMember(userID, firstName, lastName, telephone,
				new Address(street, city, state, zipCode));
		DataAccess da = new DataAccessFacade();
		da.saveNewMember(libraryMember);
	}

	@SuppressWarnings("deprecation")
	@Override
	//use case 3
	public CheckoutRecordEntry checkoutBook(String memberId, String isbn) throws LibrarySystemException{
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
		CheckoutRecordEntry entry = new CheckoutRecordEntry(bookCopy,new Date(), expireDate);
		CheckOutRecord oldRecord = da.readCheckoutRecords().get(memberId);
		if(oldRecord == null)
			oldRecord = new CheckOutRecord(memberId);
		oldRecord.addCheckOut(entry);
		//membersMap.get(memberId).addCheckoutBook(entry);
		da.saveNewCheckoutRecord(oldRecord);
		booksMap.get(isbn).updateCopies(bookCopy);
		da.saveNewBook(booksMap.get(isbn)); //save new copy
		return entry;
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
	public CheckOutRecord getCheckoutRecord(String memberId) throws LibrarySystemException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> membersMap = da.readMemberMap();
		if(!membersMap.containsKey(memberId)) {
			throw new LibrarySystemException("Member " + memberId + " not found");
		}
		HashMap<String, CheckOutRecord> records = da.readCheckoutRecords();
		if(records == null)
			return new CheckOutRecord(memberId);
		else if(records.get(memberId) == null)
			return new CheckOutRecord(memberId);
		return records.get(memberId);
        
	}

	@Override
	//use case 7
	//The method judges whether the book is overdue is in the BookCopy Class itself
	public HashMap<CheckoutRecordEntry, LibraryMember> searchOverDueBooks(String isbn) throws LibrarySystemException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> membersMap = da.readMemberMap();
		HashMap<CheckoutRecordEntry, LibraryMember> recordLibmemMaps = new HashMap<>();
        for(LibraryMember lib : membersMap.values()){
        	CheckOutRecord checkOutRecord = getCheckoutRecord(lib.getMemberId());
        	List<CheckoutRecordEntry> recordEntries = checkOutRecord.searchOverdueBookCopies(isbn);
        	for(CheckoutRecordEntry entry: recordEntries){
        		recordLibmemMaps.put(entry, lib);
        	}
        }
		return recordLibmemMaps;
	}
}
