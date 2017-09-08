/**
 * 
 */
package lesson3.labs.prob2.extpackage;

import lesson3.labs.prob2.Apartment;
import lesson3.labs.prob2.Building;
import lesson3.labs.prob2.Landload;

/**
 * @author quanyang
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Building b1 = new Building("building1",100);
		Building b2 = new Building("building2",200);
		Building b3 = new Building("building3",300);
		Apartment b1a1 = new Apartment(50);
		Apartment b1a2 = new Apartment(60);
		Apartment b1a3 = new Apartment(70);
		b1.addApartment(b1a1);
		b1.addApartment(b1a2);
		b1.addApartment(b1a3);
		Apartment b2a1 = new Apartment(60);
		Apartment b2a2 = new Apartment(70);
		Apartment b2a3 = new Apartment(80);
		Apartment b2a4 = new Apartment(90);
		b2.addApartment(b2a1);
		b2.addApartment(b2a2);
		b2.addApartment(b2a3);
		b2.addApartment(b2a4);
		Apartment b3a1 = new Apartment(70);
		Apartment b3a2 = new Apartment(80);
		Apartment b3a3 = new Apartment(90);
		Apartment b3a4 = new Apartment(100);
		Apartment b3a5 = new Apartment(110);
		b3.addApartment(b3a1);
		b3.addApartment(b3a2);
		b3.addApartment(b3a3);
		b3.addApartment(b3a4);
		b3.addApartment(b3a5);
		
		Landload landload = new Landload();
		landload.addBuilding(b1);
		landload.addBuilding(b2);
		landload.addBuilding(b3);
		int income = landload.calcIncome();
		System.out.print("The income of the landlord is ");
		System.out.println(income);
	}
	

}
