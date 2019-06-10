package br.unicap.bank.model;

public class TaxAccount  extends AbstractAccount{
	private static final double tax = 0.001;
	
	public TaxAccount (String id, double balance, User client) {
		super(id, balance, client);
	}
	
	public TaxAccount (String id, double balance) {
		super(id, balance);
	}
	
	public TaxAccount (String id) {
		super(id);
	}
	
	public double getTax() {
		return TaxAccount.tax;
	}
	
	
	public double taxValue (double value) {
		return value + value*getTax();
	}
	
	@Override
	public void debit(double value) {
		
		value = taxValue (value);
		if (value > 0 && this.getBalance() >= value){
			this.setBalance(this.getBalance()-value);
			System.out.println(this.getId() + " debitted -" + value);
		}
		else {
			System.out.println("It wasn't possible debit this value " + value);
		}
	}
}
