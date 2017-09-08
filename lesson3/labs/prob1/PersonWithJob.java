package lesson3.labs.prob1;

public class PersonWithJob {

	private double salary;
	private Person person;

	PersonWithJob(Person p, double s) {
		person = p;
		salary = s;
	}
	
	public double getSalary() {
		return salary;
	}

	public Person getPerson() {
		return person;
	}

	@Override
	public boolean equals(Object aPerson) {
		if (aPerson == null)
			return false;
		if (!(aPerson instanceof PersonWithJob))
			return false;
		PersonWithJob p = (PersonWithJob) aPerson;
		boolean isEqual = this.getPerson().equals(p.getPerson()) && this.getSalary() == p.getSalary();
		return isEqual;
	}

	public static void main(String[] args) {
		Person p = new Person("Joe");
		PersonWithJob pWithJob1 = new PersonWithJob(p, 30000);
		PersonWithJob pWithJob2 = new PersonWithJob(p, 30000);
		PersonWithJob pWithJob3 = new PersonWithJob(p, 50000);
		// As PersonsWithJobs, p1 should be equal to p2
		System.out.println("pWithJob1.equals(pWithJob2)? " + pWithJob1.equals(pWithJob2));
		System.out.println("pWithJob1.equals(pWithJob3)? " + pWithJob1.equals(pWithJob3));
	}

}
