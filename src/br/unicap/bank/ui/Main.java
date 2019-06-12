package br.unicap.bank.ui;
import java.util.Scanner;

import br.unicap.bank.data.AccountsRepository;

import br.unicap.bank.model.CtrlAccount;


import br.unicap.bank.data.UserRepository;
import br.unicap.bank.exceptions.InsuficientBalanceException;
import br.unicap.bank.exceptions.NegativeCreditException;
import br.unicap.bank.exceptions.NegativeDebitException;
import br.unicap.bank.model.AbstractAccount;
import br.unicap.bank.model.Account;
import br.unicap.bank.model.SavingsAccount;
import br.unicap.bank.model.User;


public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		User u1, u2, u3;
		
		u1 = new User("Aderbal", "000.000.000-00", "01/04/2000");
		u2 = new User("Etevaldo", "111.111.111-11", "02/03/1980");
		u3 = new User("Zidane", "222.222.222-22", "03/05/1975");
		
		Facade.init();
		try {
			Facade.getInstance().create(u1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Facade.getInstance().create(u2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Facade.getInstance().create(u3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//testAccount();
		//testSavingAccount();
		//testAccountRepository();
		//testUser();
		//testUserRepository();
		
		//AccountsRepository rep = new AccountsRepository(10);
		//CtrlAbstractAccount ctrl = new CtrlAbstractAccount(rep);
		

		input.close();
	
	}
	
	public static void testAccount() {
		// Testing Account
		Account c1, c2, c3;
		
		c1 = new Account ("0000-0");
		c2 = new Account("0001-0");
		c3 = new Account("0002-0");
		
		try {
			c1.credit(100);
		} catch (NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			c2.credit(200);
		}catch (NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try{
			c3.credit(300);
		}catch (NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			c1.debit(10);
		} catch (NegativeDebitException | InsuficientBalanceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			c2.debit(10);
		} catch (NegativeDebitException | InsuficientBalanceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			c3.debit(10);
		} catch (NegativeDebitException | InsuficientBalanceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			c3.transference(290, c1);
		} catch (NegativeDebitException | InsuficientBalanceException | NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			c1.transference(380, c2);
		} catch (NegativeDebitException | InsuficientBalanceException | NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try{
			c2.transference(380, c1);
		} catch (NegativeDebitException | InsuficientBalanceException | NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Balance of c1: " + c1.getBalance());
		System.out.println("Balance of c2: " + c2.getBalance());
		System.out.println("Balance of c3: " + c3.getBalance());
	}
	
	public static void testSavingAccount() {
		// Testing SavingsAccount
		SavingsAccount p1, p2, p3;
		p1 = new SavingsAccount("1234-0", 0.0);
		p2 = new SavingsAccount("9876-0", 0.0);
		p3 = new SavingsAccount("4567-1", 0.0);
		
		try{
			p1.credit(100);
		}catch (NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try{
			p2.credit(200);
		}catch (NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			p3.credit(300);
		}catch (NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			p1.earnInterest(0.01f);
		} catch (NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			p2.earnInterest(0.1f);
		} catch (NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		try {
			p3.earnInterest(0.5f);
		} catch (NegativeCreditException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Balance of p1: " + p1.getBalance());
		System.out.println("Balance of p2: " + p2.getBalance());
		System.out.println("Balance of p3: " + p3.getBalance());
	}
	
	public static void testAccountRepository() {
		// Testing AccountRespository
		AbstractAccount c1, c2, c3;
		
		c1 = new Account ("0000-0");
		c2 = new Account("0001-0");
		c3 = new Account("0002-0");
		
		SavingsAccount p1, p2, p3;
		p1 = new SavingsAccount("1234-0", 0.0);
		p2 = new SavingsAccount("9876-0", 0.0);
		p3 = new SavingsAccount("4567-1", 0.0);
		
		AccountsRepository eBank;
		
		eBank = new AccountsRepository(100);
		
		eBank.create(c1);
		eBank.create(c2);
		eBank.create(c3);
		eBank.create(p1);
		eBank.create(p2);
		eBank.create(p3);
		
		System.out.println(eBank);
		
		System.out.println(eBank.read("9876-0"));
		
		System.out.println(eBank.read("0000-0"));
		System.out.println(eBank.read("1234-0"));
		System.out.println(eBank.read("1234-1"));
		
		
		eBank.delete(c2);
		eBank.delete(p1);
		
		System.out.println(eBank);
	}
	
	public static void testUser () {
		// Testing User
		User u1, u2, u3;
		
		u1 = new User("Aderbal", "000.000.000-00", "01/04/2000");
		u2 = new User("Etevaldo", "111.111.111-11", "02/03/1980");
		u3 = new User("Zidane", "222.222.222-22", "03/05/1975");
		
		System.out.println(u1.getName());
		System.out.println(u1.getAge());
		System.out.println(u1.getCpf());
		System.out.println(u1.getKind());
		System.out.println();
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);
		System.out.println(u3.getKind());
		u3.setKind(2);
		System.out.println(u3.getKind());
	}
	/*
	public static void testUserRepository() {
		// Testing UserRepository
		User u1, u2, u3;
		
		u1 = new User("Aderbal", "000.000.000-00", "01/04/2000");
		u2 = new User("Etevaldo", "111.111.111-11", "02/03/1980");
		u3 = new User("Zidane", "222.222.222-22", "03/05/1975");
		
		UserRepository clients;
		
		clients = new UserRepository (100);
		clients.add(u1);
		clients.add(u3);
		
		System.out.println(clients);
		
		clients.remove(u1);
		clients.add(u2);
		
		System.out.println(clients);

		System.out.println(clients.get(u1));
		System.out.println(clients.get(u2));
		System.out.println(clients.exist(u2));
	}
	*/

}
