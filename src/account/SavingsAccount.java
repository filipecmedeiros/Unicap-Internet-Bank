package account;

public class SavingsAccount extends Account{
	
	public SavingsAccount(String number, double balance) {
		super(number, balance);
	}
	
	public boolean earnInterest (float interest) {
		boolean operation = false;
		double balance = this.getBalance();
		operation = this.credit(balance*interest);
		return operation;
	}
}
