package br.unicap.bank.model;

import br.unicap.bank.exceptions.NegativeCreditException;

public class BonifiedAccount extends Account{
	private double bonus;
	private final float tax;
	
	public BonifiedAccount (String id, double balance, float tax) {
		super(id, balance);
		this.bonus = 0;
		this.tax = tax;
	}
	
	public BonifiedAccount (String id) {
		super(id);
		this.bonus = 0;
		this.tax = 0.01f;
	}
	
	public double getBonus() {
		return this.bonus;
	}
	
	public void setBonus (double value) {
		this.bonus = value;
	}
	
	public double getTax() {
		return tax;
	}

	
	@Override
	public void credit(double value) throws NegativeCreditException{
		super.credit(value);	
		setBonus(getBonus()+value*getTax());
	}
	
	public void bonusReward () throws NegativeCreditException{
		super.credit(getBonus());
		setBonus(0);
	}
	
}
