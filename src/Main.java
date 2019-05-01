import java.util.Scanner;

import account.Account;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account c1, c2, c3;
		
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
		
		input.close();
	
	}

}
