package lesson4.labs.prob4E;

public class SavingsAccount extends Account {
	private double balance;
	private double interestRate;
	private String accId;

	public SavingsAccount(String accId, double interestRate, double balance) {
		this.accId = accId;
		this.interestRate = interestRate;
		this.balance = balance;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String getAccountID() {
		return accId;
	}

	public void setAccountID(String accId) {
		this.accId = accId;
	}
	
	@Override
	public double computeUpdatedBalance() {
		return balance + (interestRate * balance);
	}
}
