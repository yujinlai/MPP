package ui.ruleengine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ui.AddAuthorWindow;
import ui.controller.LibController;

public class AuthorRuleSet implements RuleSet {
	
	private AddAuthorWindow author;
	private String tele_regex = "^([0-9]{3}[-][0-9]{3}[-][0-9]{4})$";

	@Override
	public void applyRules(LibController ob) throws RuleException {
		author = (AddAuthorWindow) ob;
		nonemptyRule();
		isNumericRule();
		telephoneFormatRule();
	}
	
	private void nonemptyRule() throws RuleException {
		if(author.getFirstName().getText().trim().isEmpty() ||
				author.getLastName().getText().trim().isEmpty() ||
				author.getCredentials().getText().trim().isEmpty() ||
				author.getPhoneNumber().getText().trim().isEmpty() ||
				author.getBio().getText().trim().isEmpty() ||
				author.getStreet().getText().trim().isEmpty() ||
				author.getCity().getText().trim().isEmpty() ||
				author.getState().getText().trim().isEmpty() ||
				author.getZip().getText().trim().isEmpty()
				) {
			throw new RuleException("All fields must be non-empty!");
		}
	}

	private void isNumericRule() throws RuleException {
		String val = author.getZip().getText().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Zip code must be numeric");
		}	
	}
	
	private void telephoneFormatRule() throws RuleException {
		String val = author.getPhoneNumber().getText().trim();
		Pattern pattern = Pattern.compile(tele_regex);
		Matcher matcher = pattern.matcher(val);
		if(!matcher.matches())
			throw new RuleException("The telephone must be xxx-xxx-xxxx!");
	}
}