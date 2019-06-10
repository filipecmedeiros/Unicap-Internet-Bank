package br.unicap.bank.exceptions;

public class NegativeDebitException extends Exception {

	public NegativeDebitException() {
		super("It wasn't possible debit this value");
	}
}
