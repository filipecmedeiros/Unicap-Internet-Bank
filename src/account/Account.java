package account;

public class Account {
	private String id;
	private double balance;
	
	public Account(String id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public Account (String id) {
		this.id = id;
		this.balance = 0;
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
	
	public boolean debit (double value) {
		boolean operation = false;
		
		if (value > 0 && this.balance >= value){
			this.balance -= value;
			operation = true;
			System.out.println(this.id + " debitted -" + value);
		}
		else {
			System.out.println("It wasn't possible debit this value " + value);
		}
		return operation;
	}
	
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
