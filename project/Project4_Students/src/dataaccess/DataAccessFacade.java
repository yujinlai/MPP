package dataaccess;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import business.Book;
import business.CheckOutRecord;
import business.LibraryMember;

public class DataAccessFacade implements DataAccess {

	enum StorageType {
		BOOKS, MEMBERS, USERS, CHECKOUTRECORDS;
	}

	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "\\src\\dataaccess\\storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	//implement: other save operations
	public void saveNewMember(LibraryMember member) {
		HashMap<String, LibraryMember> mems = readMemberMap();
		String memberId = member.getMemberId();
		mems.put(memberId, member);
		saveToStorage(StorageType.MEMBERS, mems);
	}

	public void saveNewBook(Book book) {
		HashMap<String, Book> books = readBooksMap();
		String isbn = book.getIsbn();
		books.put(isbn, book);
		saveToStorage(StorageType.BOOKS, books);
	}

	public void addBookCopy(String isbn) {
		HashMap<String, Book> books = readBooksMap();
		Book book = books.get(isbn);
		book.addCopy();
		books.put(isbn, book);
		saveToStorage(StorageType.BOOKS, books);
	}

	public void saveNewUser(User user) {
		HashMap<String, User> users = readUserMap();
		String userID = user.getId();
		users.put(userID, user);
		saveToStorage(StorageType.USERS, users);
	}
	
	@Override
	public void saveNewCheckoutRecord(CheckOutRecord record) {
		HashMap<String, CheckOutRecord> records = readCheckoutRecords();
		String memberID = record.getMemberID();
		records.put(memberID, record);
		saveToStorage(StorageType.CHECKOUTRECORDS, records);		
	}

	@SuppressWarnings("unchecked")
	public HashMap<String,Book> readBooksMap() {
		//Returns a Map with name/value pairs being
		//   isbn -> Book
		return (HashMap<String,Book>) readFromStorage(StorageType.BOOKS);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readMemberMap() {
		//Returns a Map with name/value pairs being
		//   memberId -> LibraryMember
		return (HashMap<String, LibraryMember>) readFromStorage(
				StorageType.MEMBERS);
	}


	@SuppressWarnings("unchecked")
	public HashMap<String, User> readUserMap() {
		//Returns a Map with name/value pairs being
		//   userId -> User
		return (HashMap<String, User>)readFromStorage(StorageType.USERS);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public HashMap<String, CheckOutRecord> readCheckoutRecords() {
		//Returns a Map with member/value pairs being
		//   memberId -> CheckOutRecord
		if(readFromStorage(StorageType.CHECKOUTRECORDS) == null)
			return new HashMap<String, CheckOutRecord>();
		return (HashMap<String, CheckOutRecord>)readFromStorage(StorageType.CHECKOUTRECORDS);
	}


	/////load methods - these place test data into the storage area
	///// - used just once at startup
	//static void loadMemberMap(List<LibraryMember> memberList) {

	static void loadBookMap(List<Book> bookList) {
		HashMap<String, Book> books = new HashMap<String, Book>();
		bookList.forEach(book -> books.put(book.getIsbn(), book));
		saveToStorage(StorageType.BOOKS, books);
	}
	static void loadUserMap(List<User> userList) {
		HashMap<String, User> users = new HashMap<String, User>();
		userList.forEach(user -> users.put(user.getId(), user));
		saveToStorage(StorageType.USERS, users);
	}

	static void loadMemberMap(List<LibraryMember> memberList) {
		HashMap<String, LibraryMember> members = new HashMap<String, LibraryMember>();
		memberList.forEach(member -> members.put(member.getMemberId(), member));
		saveToStorage(StorageType.MEMBERS, members);
	}
	
	static void loadCheckoutRecords(List<CheckOutRecord> recordsList) {
		HashMap<String, CheckOutRecord> members = new HashMap<String, CheckOutRecord>();
		recordsList.forEach(member -> members.put(member.getMemberID(), member));
		saveToStorage(StorageType.CHECKOUTRECORDS, members);
	}

	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}

	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch(Exception e) {
		    //e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}



	final static class Pair<S,T> implements Serializable{

		S first;
		T second;
		Pair(S s, T t) {
			first = s;
			second = t;
		}
		@Override
		public boolean equals(Object ob) {
			if(ob == null) return false;
			if(this == ob) return true;
			if(ob.getClass() != getClass()) return false;
			@SuppressWarnings("unchecked")
			Pair<S,T> p = (Pair<S,T>)ob;
			return p.first.equals(first) && p.second.equals(second);
		}

		@Override
		public int hashCode() {
			return first.hashCode() + 5 * second.hashCode();
		}
		@Override
		public String toString() {
			return "(" + first.toString() + ", " + second.toString() + ")";
		}
		private static final long serialVersionUID = 5399827794066637059L;
	}
	
	public static void main(String[] args) {
		DataAccessFacade a = new DataAccessFacade();
		HashMap<String, LibraryMember> aaMap = a.readMemberMap();
		for(String id : aaMap.keySet()) {
			System.out.println(id);
		}    	
	}
}
