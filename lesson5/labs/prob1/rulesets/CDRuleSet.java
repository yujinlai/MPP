package lesson5.labs.prob1.rulesets;

import java.awt.Component;

import lesson5.labs.prob1.gui.CDWindow;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {
	
	private CDWindow cd;

	@Override
	public void applyRules(Component ob) throws RuleException {
		cd = (CDWindow) ob;
		nonemptyRule();
		priceFormatAndRangeRule();
	}
	
	private void nonemptyRule() throws RuleException {
		if(cd.getArtistValue().trim().isEmpty() ||
				cd.getTitleValue().trim().isEmpty() ||
				cd.getPriceValue().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}
	
	private void priceFormatAndRangeRule() throws RuleException {
		String val = cd.getPriceValue().trim();
		float price = 0;
		try {
			price = Float.parseFloat(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Price must be floating point number");
		}
		if(val.indexOf(val.length()-2) != '.')
			throw new RuleException("Price must be a floating point number with two decimal places");
		if((price-0.49) <0 || Math.abs(price - 0.49) <= 0.00000000001) 
			throw new RuleException("Price must be greater than 0.49");
	}
	
}
