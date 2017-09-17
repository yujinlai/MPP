package ui.ruleengine;

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
	private CheckoutBookController checkoutBook;
	
	@Override
	public void applyRules(LibController ob) throws RuleException {
		checkoutBook = (CheckoutBookController) ob;
		nonemptyRule();
		isNumericRule();
		lengthRule();
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
		String ISBN = checkoutBook.getIsbn().getText().trim();
		try {
			Integer.parseInt(ISBN);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("ISBN must be numeric");
		}
	}
	
	private void lengthRule() throws RuleException {
		String val = checkoutBook.getIsbn().getText().trim();
		if(val.length() != 10 && val.length() != 13)
			throw new RuleException("Isbn must be numeric");
		if(val.length() == 10) {
			if(!val.startsWith("0") && !val.startsWith("1"))
				throw new RuleException("The first digit should be 0 or 1 in the case that Isbn has length 10");
		}
		if(val.length() == 13) {
			if(!val.startsWith("978") && !val.startsWith("979"))
				throw new RuleException("The first digit should be either 978 or 979 in the case that Isbn has length 13");
		}
	}
}
