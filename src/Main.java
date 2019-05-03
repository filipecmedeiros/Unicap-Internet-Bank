import java.util.Scanner;

import account.Account;
import account.AccountsRepository;
import account.SavingsAccount;
import user.User;
import user.UserRepository;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Testing Account
		Account c1, c2, c3;
		SavingsAccount p1, p2, p3;
		
		c1 = new Account ("0000-0");
		c2 = new Account("0001-0");
		c3 = new Account("0002-0");
		
		c1.credit(100);
		c2.credit(200);
		c3.credit(300);
		
		c1.debit(10);
		c2.debit(10);
		c3.debit(10);
		
		c3.transference(290, c1);
		c1.transference(380, c2);
		c2.transference(380, c1);
		
		System.out.println("Balance of c1: " + c1.getBalance());
		System.out.println("Balance of c2: " + c2.getBalance());
		System.out.println("Balance of c3: " + c3.getBalance());
	
		
		// Testing SavingsAccount
		p1 = new SavingsAccount("1234-0", 0.0);
		p2 = new SavingsAccount("9876-0", 0.0);
		p3 = new SavingsAccount("4567-1", 0.0);
		
		p1.credit(100);
		p2.credit(200);
		p3.credit(300);
		
		p1.earnInterest(0.01f);
		p2.earnInterest(0.1f);
		p3.earnInterest(0.5f);
		
		System.out.println("Balance of p1: " + p1.getBalance());
		System.out.println("Balance of p2: " + p2.getBalance());
		System.out.println("Balance of p3: " + p3.getBalance());
		
		
		// Testing AccountRespository
		AccountsRepository eBank;
		
		eBank = new AccountsRepository(100);
		
		boolean result;
		result = eBank.add(c1);
		System.out.println(result);
		eBank.add(c2);
		eBank.add(c3);
		eBank.add(p1);
		//eBank.add(p2);
		eBank.add(p3);
		
		System.out.println(eBank);
		
		System.out.println(eBank.get(p2));
		
		System.out.println(eBank.get(c1));
		System.out.println(eBank.get(p1));
		
		
		eBank.remove(c2);
		eBank.remove(p1);
		
		System.out.println(eBank);
		
		
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
		

		// Testing UserRepository
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
		
		
		/*
		int menu;
		do {
			System.out.println("Menu:");
			System.out.println("1. Criar uma conta");
			System.out.println("2. Creditar valor a uma conta");
			System.out.println("3. Debitar valor a uma conta");
			System.out.println("4. Transferir valor entre contas");
			System.out.println("0. Sair");
			menu = input.nextInt();
			
			switch(menu) {
				case 0: break;
				case 1:
						
						break;
				case 2:
						break;
				case 3: 
						break;
				case 4: 
						break;
				default: System.out.println("Menu não identificado");
						break;
				
			}
			
		}while(menu!=0);
		*/
		input.close();
	
	}

}
