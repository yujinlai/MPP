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
public class Building {
	private String name;
	private int costs;
	private List<Apartment> apartments = new ArrayList<>();
	
	public void addApartment(Apartment apartment) {
		apartments.add(apartment);
	}
	/**
	 * @param name
	 * @param costs
	 */
	//package level
	public Building(String name, int costs) {
		this.name = name;
		this.costs = costs;
	}
	
	public int getProfit() {
		int sumRent = 0;
		for(Apartment a:apartments) {
			sumRent += a.getRent();
		}
		return sumRent - costs;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the costs
	 */
	public int getCosts() {
		return costs;
	}
	/**
	 * @param costs the costs to set
	 */
	public void setCosts(int costs) {
		this.costs = costs;
	}
	/**
	 * @return the apartments
	 */
	public List<Apartment> getApartments() {
		return apartments;
	}
	/**
	 * @param apartments the apartments to set
	 */
	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}
	
	
}
