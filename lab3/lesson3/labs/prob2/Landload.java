/**
 * 
 */
package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author quanyang
 *
 */
public class Landload {
	private List<Building> buildings = new ArrayList<>();

	public void addBuilding(Building building) {
		buildings.add(building);
	}
	public int calcIncome() {
		int totalProfit=0;
		for(Building b:buildings) {
			totalProfit += b.getProfit();
		}
		return totalProfit;
	}
}
