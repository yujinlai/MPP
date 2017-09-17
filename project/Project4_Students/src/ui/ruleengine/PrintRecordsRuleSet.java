package ui.ruleengine;

import ui.controller.LibController;
import ui.controller.PrintController;

public class PrintRecordsRuleSet implements RuleSet {
	private PrintController printCtrl;

	@Override
	public void applyRules(LibController libContrl) throws RuleException {
		printCtrl = (PrintController)libContrl;
		nonemptyRule();
		isNumericRule();
	}
	
	private void nonemptyRule() throws RuleException {
		if (printCtrl.getMemberID().getText().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
    }
	
	private void isNumericRule() throws RuleException {
		String val = printCtrl.getMemberID().getText().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Member ID must be numeric");
		}	
	}
}
