package account;

public class TaxAccount extends AbstractAccount{
	private double tax;
	
	public TaxAccount(String id, double balance) {
		super(id, balance);
	}
	
	public double getTax() {
		return this.tax;
	}
	
	public void setTax(double tax) {
		if (tax > 0) {
			this.tax = tax;
		}
	}
	
	public double taxValue (double value) {
		return value + value*getTax();
	}
	
	@Override
	public boolean debit(double value) {
		boolean operation = false;
		
		value = taxValue (value);
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
