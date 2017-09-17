package ui.ruleengine;

import ui.controller.LibController;
import ui.controller.LoginController;

public class LoginRuleSet implements RuleSet {
	private LoginController login;

	@Override
	public void applyRules(LibController libContrl) throws RuleException {
		login = (LoginController)libContrl;
		nonemptyRule();
		
	}
	
	private void nonemptyRule() throws RuleException {
		if (login.getUsernameField().getText().trim().isEmpty() ||
				login.getPasswordField().getText().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
    }
}
