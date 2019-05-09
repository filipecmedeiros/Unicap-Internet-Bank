package account;

public class Account extends AbstractAccount {
	
	public Account(String id, double balance) {
		this.setId(id);
		this.setBalance(balance);
	}
	
	public Account (String id) {
		this.setId(id);
		this.setBalance(0);
	}
	
	@Override
	public boolean debit (double value) {
		boolean operation = false;
		
		if (value > 0 && this.getBalance() >= value){
			this.setBalance(this.getBalance()-value);
			operation = true;
			System.out.println(this.getId() + " debitted -" + value);
		}
		else {
			System.out.println("It wasn't possible debit this value " + value);
		}
		return operation;
	}
}
