package br.unicap.bank.model;

import br.unicap.bank.exceptions.InsuficientBalanceException;
import br.unicap.bank.exceptions.NegativeCreditException;
import br.unicap.bank.exceptions.NegativeDebitException;

public abstract class AbstractAccount {
	private String id;
	private double balance;
	private User client;

	public AbstractAccount(String id, double balance, User client) {
		this.id = id;
		this.balance = balance;
		this.setClient(client);
	}

	public AbstractAccount(String id, double balance) {
		this.id = id;
		this.balance = balance;
		this.setClient(null);
	}

	public AbstractAccount(String id) {
		this.id = id;
		this.balance = 0;
		this.setClient(null);
	}

	@Override
	public String toString() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		boolean operation = false;
		if (obj instanceof AbstractAccount) {
			AbstractAccount absAccount = (AbstractAccount) obj;
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

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public void credit(double value) throws NegativeCreditException{

		if (value > 0) {
			this.balance += value;
		} else {
			throw new NegativeCreditException();
		}
	}

	public abstract void debit(double value) throws NegativeDebitException, InsuficientBalanceException;

	public void transference(double value, AbstractAccount destiny) throws NegativeDebitException, InsuficientBalanceException, NegativeCreditException {
		this.debit(value);
		destiny.credit(value);
	}

}
