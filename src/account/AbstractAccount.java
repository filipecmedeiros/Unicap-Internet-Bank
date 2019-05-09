package account;

public abstract class AbstractAccount {
	private String id;
	private double balance;
	
	@Override
	public String toString() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean operation = false;
		if (obj instanceof Account) {
			AbstractAccount absAccount = (Account) obj;
			operation = this.id.equals(absAccount.id) && this.balance == absAccount.balance;
		}
		
		return operation;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean credit (double value) {
		boolean operation = false;
		
		if (value>0) {
			this.balance += value;
			operation = true;
			System.out.println(this.id + " creditted +" + value);
		}
		else {
			System.out.println("It wasn't possible credit this value " + value);
		}
		return operation;
	}
	
	public abstract boolean debit (double value);
	
	public boolean transference (double value, Account destiny) {
		boolean operation = false;
		
		System.out.println("========= Transference ====== ");
		
		if (this.debit(value)){
			operation = destiny.credit(value);
		}
		System.out.println("============================== ");
		
		return operation;
	}
}
