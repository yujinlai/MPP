package ui.rulesets;

import java.util.HashMap;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.AddBookWindow;
import ui.AddLibMemberWindow;
import ui.LoginWindow;

final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends Pane>, RuleSet> map1 = new HashMap<>();
	static HashMap<Class<? extends Stage>, RuleSet> map2 = new HashMap<>();
	static {
		map1.put(AddLibMemberWindow.class, new LibraryMemberRuleSet());
		map1.put(AddBookWindow.class, new BookRuleSet());
		map2.put(LoginWindow.class, new LoginRuleSet());
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
}
