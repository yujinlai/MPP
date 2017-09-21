package lesson9.labs.prob1.business;

import java.util.*;
import java.util.stream.Collectors;

import lesson9.labs.prob1.dataaccess.DataAccess;
import lesson9.labs.prob1.dataaccess.DataAccessFacade;
import lesson9.labs.prob1.business.Book;
import lesson9.labs.prob1.business.LibraryMember;

public class Main {

	public static void main(String[] args) {
		System.out.println(allWhoseZipContains3());
		System.out.println(allHavingAtLeastTwoCopies());
		System.out.println(allHavingMultipleAuthors());

	}
	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
	public static List<String> allWhoseZipContains3() {
		DataAccess da = new DataAccessFacade();
		Collection<LibraryMember> members = da.readMemberMap().values();
		List<LibraryMember> mems = new ArrayList<>();
		mems.addAll(members);
		
		//implement
		List<String> memberIDS =
						mems.stream()
							.filter(m -> m.getAddress().getZip().contains("3"))
							.map(m -> m.getMemberId())
							.collect(Collectors.toList());

		return memberIDS;
		
	}
	//Returns a list of all isbns of books having at least two copies
		public static List<String> allHavingAtLeastTwoCopies() {
			DataAccess da = new DataAccessFacade();
			Collection<Book> books = da.readBooksMap().values();
			List<Book> bs = new ArrayList<>();
			bs.addAll(books);
			
			//implement
			List<String> isbnWithCopies =
					  bs.stream()
						.filter(b -> b.getCopies().length >= 2)
						.map(b -> b.getIsbn())
						.collect(Collectors.toList());
			
			return isbnWithCopies;
			
		}
	
	//Returns a list of all isbns of  Books that have multiple authors
	public static List<String> allHavingMultipleAuthors() {
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		
		//implement
		List<String> isbnWithAuthors =
				  bs.stream()
					.filter(b -> b.getAuthors().size() >= 2)
					.map(b -> b.getIsbn())
					.collect(Collectors.toList());
		
		return isbnWithAuthors;
		
		}

}
