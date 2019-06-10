package br.unicap.bank.model;

import br.unicap.bank.exceptions.NegativeCreditException;

public class SavingsAccount extends Account{
	
	public SavingsAccount(String id, double balance) {
		super(id, balance);
	}
	
	public SavingsAccount (String id) {
		super(id);
	}
	
	public void earnInterest (float tax) throws NegativeCreditException{
		this.credit(this.getBalance()*tax);
	}

}
