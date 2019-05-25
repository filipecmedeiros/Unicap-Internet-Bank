package account;

public class SavingsAccount extends Account{
	
	public SavingsAccount(String id, double balance) {
		super(id, balance);
	}
	
	public SavingsAccount (String id) {
		super(id);
	}
	
	public boolean earnInterest (float interest) {
		boolean operation = false;
		double balance = this.getBalance();
		operation = this.credit(balance*interest);
		return operation;
	}

}
