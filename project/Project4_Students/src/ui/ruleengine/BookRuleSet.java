package ui.ruleengine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ui.AddBookWindow;
import ui.controller.LibController;


/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Number of copies must be numeric and consist of either 10 or 13 characters
 * 3. Isbn can only contains 0-9 and '-'.
 *
 */
public class BookRuleSet implements RuleSet {
	
	private AddBookWindow book;
	private String isbn_regex = "^([0-9-]+)$";

	@Override
	public void applyRules(LibController ob) throws RuleException {
		book = (AddBookWindow) ob;
		nonemptyRule();
		isNumericRule();
		isbnFormatRule();
	}
	
	private void nonemptyRule() throws RuleException {
		if(book.getIsbn().getText().trim().isEmpty() ||
				book.getTitle().getText().trim().isEmpty() ||
				book.getNumOfCopies().getText().trim().isEmpty() ||
				book.getAuthors().size() == 0) {
			throw new RuleException("All fields must be non-empty!");
		}
	}

	private void isNumericRule() throws RuleException {
		String val = book.getNumOfCopies().getText().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Number of copies must be numeric");
		}	
	}
	
	private void isbnFormatRule() throws RuleException {
		String val = book.getIsbn().getText().trim();
		Pattern pattern = Pattern.compile(isbn_regex);
		Matcher matcher = pattern.matcher(val);
		if(!matcher.matches())
			throw new RuleException("The isbn must only contain with '0-9' and '-'!");
	}
}
