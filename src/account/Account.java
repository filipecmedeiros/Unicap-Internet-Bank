package account;

import user.User;

public class Account extends AbstractAccount {
	
	public Account (String id, double balance, User client) {
		super(id, balance, client);
	}
	
	public Account(String id, double balance) {
		super(id, balance);
	}
	
	public Account (String id) {
		super(id);
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
