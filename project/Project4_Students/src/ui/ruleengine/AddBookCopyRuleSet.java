package ui.ruleengine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ui.controller.AddBookCopyController;
import ui.controller.LibController;

/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be in formal
 *
 */
public class AddBookCopyRuleSet implements RuleSet {
	private String isbn_regex = "^([0-9-]+)$";
	private AddBookCopyController book;

	@Override
	public void applyRules(LibController libContrl) throws RuleException {
		book = (AddBookCopyController) libContrl;
		nonemptyRule();
		isbnFormatRule();
	}

	private void nonemptyRule() throws RuleException {
		if(book.getIsbn().getText().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
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
