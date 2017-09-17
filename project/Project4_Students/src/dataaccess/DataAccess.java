package dataaccess;

import java.util.HashMap;

import business.Book;
import business.CheckOutRecord;
import business.LibraryMember;

public interface DataAccess {
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public HashMap<String, CheckOutRecord> readCheckoutRecords();
	public void saveNewMember(LibraryMember member);
	public void saveNewBook(Book book);
	public void saveNewUser(User user);
	public void addBookCopy(String isbn);
	public void saveNewCheckoutRecord(CheckOutRecord record);
}
