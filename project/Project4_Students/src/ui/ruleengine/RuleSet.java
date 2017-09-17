package ui.ruleengine;

import ui.controller.LibController;

public interface RuleSet {
	public void applyRules(LibController ob) throws RuleException;
}

