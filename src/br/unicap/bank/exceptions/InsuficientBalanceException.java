package br.unicap.bank.exceptions;

public class InsuficientBalanceException extends Exception {
	
	public InsuficientBalanceException () {
		super("It wasn't possible debit this value");
	}
}
