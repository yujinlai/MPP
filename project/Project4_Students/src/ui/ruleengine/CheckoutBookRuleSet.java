package ui.ruleengine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ui.controller.CheckoutBookController;
import ui.controller.LibController;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. memberID and ISBN must be numeric 
 *  3. Isbn must be in isbn format
 */
public class CheckoutBookRuleSet implements RuleSet {
	private String isbn_regex = "^([0-9-]+)$";
	
	private CheckoutBookController checkoutBook;
	
	@Override
	public void applyRules(LibController ob) throws RuleException {
		checkoutBook = (CheckoutBookController) ob;
		nonemptyRule();
		isNumericRule();
		isbnFormatRule();
	}

	private void nonemptyRule() throws RuleException {
		if (checkoutBook.getMemberID().getText().trim().isEmpty() ||
				checkoutBook.getIsbn().getText().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}
	
	private void isNumericRule() throws RuleException {
		String val = checkoutBook.getMemberID().getText().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Member ID must be numeric");
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
