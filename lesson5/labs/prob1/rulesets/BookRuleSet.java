package lesson5.labs.prob1.rulesets;

import java.awt.Component;

import lesson5.labs.prob1.gui.BookWindow;

/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {
	
	private BookWindow book;

	@Override
	public void applyRules(Component ob) throws RuleException {
		book = (BookWindow) ob;
		nonemptyRule();
		idNumericRule();
		lengthRule();
		priceFormatAndRangeRule();		
	}
	
	private void nonemptyRule() throws RuleException {
		if(book.getIsbnValue().trim().isEmpty() ||
				book.getTitleValue().trim().isEmpty() ||
				book.getPriceValue().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}

	private void idNumericRule() throws RuleException {
		String val = book.getIsbnValue().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Isbn must be numeric");
		}	
	}
	
	private void lengthRule() throws RuleException {
		String val = book.getIsbnValue().trim();
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

	private void priceFormatAndRangeRule() throws RuleException {
		String val = book.getPriceValue().trim();
		float price = 0;
		try {
			price = Float.parseFloat(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Price must be floating point number");
		}
		if(val.charAt(val.length()-2-1 ) != '.')
			throw new RuleException("Price must be a floating point number with two decimal places");
		if((price-0.49) <0 || Math.abs(price - 0.49) <= 0.00000001) 
			throw new RuleException("Price must be greater than 0.49");
	}
}
