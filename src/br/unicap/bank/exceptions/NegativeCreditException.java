package br.unicap.bank.exceptions;

public class NegativeCreditException extends Exception {
	
	public NegativeCreditException() {
		super("It wasn't possible credit this value");
	}
}
