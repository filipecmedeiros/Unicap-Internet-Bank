package account;

public class BonifiedAccount extends Account{
	private double bonus;
	private double interest;
	
	public BonifiedAccount (String id, double balance, double interest) {
		super(id, balance);
		this.bonus = 0;
		this.interest = interest;
	}
	
	public BonifiedAccount (String id) {
		super(id);
		this.bonus = 0;
	}
	
	public double getBonus() {
		return this.bonus;
	}
	
	public void setBonus (double value) {
		this.bonus = value;
	}
	
	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	@Override
	public boolean credit(double value) {
		boolean operation = super.credit(value);	
		
		if (operation == true) {
			setBonus(getBonus()+value*getInterest());
		}
		
		return operation;
	}
	
}
