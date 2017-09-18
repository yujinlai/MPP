package ui.ruleengine;

import java.util.HashMap;

import ui.AddAuthorWindow;
import ui.AddBookWindow;
import ui.controller.AddBookCopyController;
import ui.controller.AddMemberController;
import ui.controller.CheckOverDueController;
import ui.controller.CheckoutBookController;
import ui.controller.LibController;
import ui.controller.LoginController;
import ui.controller.PrintController;

final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends LibController>, RuleSet> map = new HashMap<>();
	static {
		map.put(LoginController.class, new LoginRuleSet());
		map.put(AddMemberController.class, new LibraryMemberRuleSet());
		map.put(CheckoutBookController.class, new CheckoutBookRuleSet());
		map.put(AddBookCopyController.class, new AddBookCopyRuleSet());
		map.put(PrintController.class, new PrintRecordsRuleSet());
		map.put(CheckOverDueController.class, new CheckOverDueRuleSet());
		map.put(AddBookWindow.class, new BookRuleSet());
		map.put(AddAuthorWindow.class, new AuthorRuleSet());
	}
	
	public static RuleSet getRuleSet(LibController c) {
		Class<? extends LibController> cl = c.getClass();
		if(!map.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No RuleSet found for this Component");
		}
		return map.get(cl);
	}
}
