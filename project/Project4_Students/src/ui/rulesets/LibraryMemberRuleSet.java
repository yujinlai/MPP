package ui.rulesets;

import java.awt.Component;
import ui.AddLibMemberWindow;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class LibraryMemberRuleSet implements RuleSet {
	
	private AddLibMemberWindow addLibMember;

	@Override
	public void applyRules(Object ob) throws RuleException {
		addLibMember = (AddLibMemberWindow) ob;
		nonemptyRule();
		priceFormatAndRangeRule();
	}
	
	private void nonemptyRule() throws RuleException {
//		if(addLibMember.getArtistValue().trim().isEmpty() ||
//				addLibMember.getTitleValue().trim().isEmpty() ||
//				addLibMember.getPriceValue().trim().isEmpty()) {
//			throw new RuleException("All fields must be non-empty!");
//		}
	}
	
	private void priceFormatAndRangeRule() throws RuleException {
//		String val = addLibMember.getPriceValue().trim();
//		float price = 0;
//		try {
//			price = Float.parseFloat(val);
//			//val is numeric
//		} catch(NumberFormatException e) {
//			throw new RuleException("Price must be floating point number");
//		}
//		if(val.length()<3 || val.charAt(val.length()-2-1) != '.')
//			throw new RuleException("Price must be a floating point number with two decimal places");
//		if((price-0.49) <0 || Math.abs(price - 0.49) <= 0.00000000001) 
//			throw new RuleException("Price must be greater than 0.49");
	}
	
}
