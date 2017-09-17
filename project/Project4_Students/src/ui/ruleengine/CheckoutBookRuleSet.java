package ui.ruleengine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ui.controller.CheckoutBookController;
import ui.controller.LibController;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. memberID and ISBN must be numeric 
 *  3. Isbn must consist of either 10 or 13 characters
 *  4. If Isbn has length 10, the first digit must be 0 or 1
 *  5. If Isbn has length 13, the first 3 digits must be either 978 or 979
 */
public class CheckoutBookRuleSet implements RuleSet {
	private String isbn_regex = "^([0-9-]+)$";
	
	private CheckoutBookController checkoutBook;
	
	@Override
	public void applyRules(LibController ob) throws RuleException {
		checkoutBook = (CheckoutBookController) ob;
		nonemptyRule();
		isbnFormatRule();
	}

	private void nonemptyRule() throws RuleException {
		if (checkoutBook.getMemberID().getText().trim().isEmpty() ||
				checkoutBook.getIsbn().getText().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}
	
	private void isbnFormatRule() throws RuleException {
		String val = checkoutBook.getIsbn().getText().trim();
		Pattern pattern = Pattern.compile(isbn_regex);
		Matcher matcher = pattern.matcher(val);
		if(!matcher.matches())
			throw new RuleException("The isbn must only contain with '0-9' and '-'!");
	}
}
