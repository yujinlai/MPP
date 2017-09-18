package ui.ruleengine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ui.controller.CheckOverDueController;
import ui.controller.LibController;

public class CheckOverDueRuleSet implements RuleSet {
	
	private String isbn_regex = "^([0-9-]+)$";
	
	private CheckOverDueController overdue;

	@Override
	public void applyRules(LibController ob) throws RuleException {
		overdue = (CheckOverDueController) ob;
		nonemptyRule();
		isbnFormatRule();	
	}
	
	private void nonemptyRule() throws RuleException {
		if (overdue.getIsbn().getText().trim().isEmpty()) {
			throw new RuleException("ISBN must be non-empty!");
		}
	}
	
	private void isbnFormatRule() throws RuleException {
		String val = overdue.getIsbn().getText().trim();
		Pattern pattern = Pattern.compile(isbn_regex);
		Matcher matcher = pattern.matcher(val);
		if(!matcher.matches())
			throw new RuleException("The isbn must only contain with '0-9' and '-'!");
	}

}
