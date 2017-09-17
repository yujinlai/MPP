package ui.ruleengine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ui.controller.AddMemberController;
import ui.controller.LibController;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class LibraryMemberRuleSet implements RuleSet {
	
	private AddMemberController addLibMember;
	
	private String tele_regex = "^([0-9]{3}[-][0-9]{3}[-][0-9]{4})$";

	@Override
	public void applyRules(LibController libContrl) throws RuleException {
		addLibMember = (AddMemberController) libContrl;
		nonemptyRule();
		idNumericRule();
		telephoneFormatRule();
	}
	
	private void nonemptyRule() throws RuleException {
		if (addLibMember.getId().getText().trim().isEmpty() || addLibMember.getFirstName().getText().trim().isEmpty()
				|| addLibMember.getLastName().getText().trim().isEmpty() || addLibMember.getTelephone().getText().trim().isEmpty()
				|| addLibMember.getStreet().getText().trim().isEmpty() || addLibMember.getCity().getText().trim().isEmpty()
				|| addLibMember.getState().getText().trim().isEmpty() || addLibMember.getZipCode().getText().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}
	
	private void idNumericRule() throws RuleException {
		String val = addLibMember.getId().getText().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Member ID must be numeric");
		}	
		String zip = addLibMember.getZipCode().getText().trim();
		try {
			Integer.parseInt(zip);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Zipcode must be numeric");
		}
	}
	
	private void telephoneFormatRule() throws RuleException {
		String val = addLibMember.getTelephone().getText().trim();
		Pattern pattern = Pattern.compile(tele_regex);
		Matcher matcher = pattern.matcher(val);
		if(!matcher.matches())
			throw new RuleException("The telephone must be xxx-xxx-xxxx!");
	}
	
}
