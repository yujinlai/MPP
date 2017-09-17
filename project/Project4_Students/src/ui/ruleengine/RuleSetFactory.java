package ui.ruleengine;

import java.util.HashMap;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.AddBookWindow;
import ui.AddLibMemberWindow;
import ui.LoginWindow;
import ui.controller.AddMemberController;
import ui.controller.CheckoutBookController;
import ui.controller.LibController;
import ui.controller.LoginController;
import ui.controller.PrintController;

final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends Pane>, RuleSet> map1 = new HashMap<>();
	static HashMap<Class<? extends Stage>, RuleSet> map2 = new HashMap<>();
	static HashMap<Class<? extends LibController>, RuleSet> map3 = new HashMap<>();
	static {
		map1.put(AddLibMemberWindow.class, new LibraryMemberRuleSet());
		map1.put(AddBookWindow.class, new BookRuleSet());
		map2.put(LoginWindow.class, new LoginRuleSet());
		map3.put(LoginController.class, new LoginRuleSet());
		map3.put(AddMemberController.class, new LibraryMemberRuleSet());
		map3.put(CheckoutBookController.class, new CheckoutBookRuleSet());
		map3.put(PrintController.class, new PrintRecordsRuleSet());
	}
	public static RuleSet getRuleSet(Pane c) {
		Class<? extends Pane> cl = c.getClass();
		if(!map1.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No RuleSet found for this Component");
		}
		return map1.get(cl);
	}
	
	public static RuleSet getRuleSet(Stage c) {
		Class<? extends Stage> cl = c.getClass();
		if(!map2.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No RuleSet found for this Component");
		}
		return map2.get(cl);
	}
	
	public static RuleSet getRuleSet(LibController c) {
		Class<? extends LibController> cl = c.getClass();
		if(!map3.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No RuleSet found for this Component");
		}
		return map3.get(cl);
	}
}
