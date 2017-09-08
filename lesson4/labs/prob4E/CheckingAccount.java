package lesson4.labs.prob4E;

public class CheckingAccount extends Account {
	private double balance;
	private double monthlyFee;
	private String accId;

	public CheckingAccount(String accId, double monthlyfee, double balance) {
		this.accId = accId;
		this.monthlyFee = monthlyfee;
		this.balance = balance;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMonthlyfee() {
		return monthlyFee;
	}

	public void setMonthlyfee(double monthlyfee) {
		this.monthlyFee = monthlyfee;
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
		return balance - monthlyFee;
	}
}
