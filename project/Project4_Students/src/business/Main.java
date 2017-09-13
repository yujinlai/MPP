package business;

import java.util.*;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class Main {

	public static void main(String[] args) {
		System.out.println(allWhoseZipContains3());
		System.out.println(allHavingOverdueBook());
		System.out.println(allHavingMultipleAuthors());
	}

	// Returns a list of all ids of LibraryMembers whose zipcode contains the
	// digit 3
	public static List<String> allWhoseZipContains3() {
		DataAccess da = new DataAccessFacade();
		Collection<LibraryMember> members = da.readMemberMap().values();
		List<String> memIds = new ArrayList<>();
		for(LibraryMember mem : members){
			String zipCode = mem.getAddress().getZip();
			if(zipCode != null && zipCode.contains("3"))
				memIds.add(mem.getMemberId());
		}
		// implement
		return memIds;
	}

	// Returns a list of all ids of LibraryMembers that have an overdue book
	public static List<String> allHavingOverdueBook() {
		DataAccess da = new DataAccessFacade();
		Collection<LibraryMember> members = da.readMemberMap().values();
		List<String> mems = new ArrayList<>();
		for(LibraryMember mem : members){
			CheckOutRecord rec = mem.getCheckoutRecord();
			if(rec != null){
				for(CheckoutRecordEntry entry : rec.getCheckOutRecords()){
					if(entry.isDue()){
						mems.add(mem.getMemberId());
						break;
					}
				}
			}
		}
		// implement
		return mems;
	}

	// Returns a list of all isbns of Books that have multiple authors
	public static List<String> allHavingMultipleAuthors() {
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();
		List<String> isbns = new ArrayList<>();
		for(Book book: books){
			if(book.getAuthors() != null && book.getAuthors().size()>0)
				isbns.add(book.getIsbn());
		}
		return isbns;
	}
}
