package ui.rulesets;

import ui.LoginWindow;

public class LoginRuleSet implements RuleSet {
	private LoginWindow login;

	@Override
	public void applyRules(Object ob) throws RuleException {
		login = (LoginWindow)ob;
		nonemptyRule();
		
	}
	
	private void nonemptyRule() throws RuleException {
		if (login.getUsernameField().getText().trim().isEmpty() ||
				login.getPasswordField().getText().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
    }
}
