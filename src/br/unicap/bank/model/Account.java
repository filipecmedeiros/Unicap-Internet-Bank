package br.unicap.bank.model;

import br.unicap.bank.exceptions.InsuficientBalanceException;
import br.unicap.bank.exceptions.NegativeDebitException;

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
	public void debit (double value) throws NegativeDebitException, InsuficientBalanceException{		
		if (value > 0) {
			if (this.getBalance() >= value) {
				this.setBalance(this.getBalance()-value);
			}
			else {
				throw new InsuficientBalanceException();
			}
		}
		else {
			throw new NegativeDebitException();
		}
	}
}
