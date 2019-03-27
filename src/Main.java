import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Conta c1, c2, c3;
		
		c1 = new Conta ("0000-0");
		c2 = new Conta("0001-0");
		c3 = new Conta("0002-0");
		
		c1.creditar(100);
		c2.creditar(200);
		c3.creditar(300);
		
		c1.debitar(10);
		c2.debitar(10);
		c3.debitar(10);
		
		c3.transferir(290, c1);
		c1.transferir(380, c2);
		c2.transferir(380, c1);
		
		System.out.println("Saldo de c1: " + c1.getSaldo());
		System.out.println("Saldo de c2: " + c2.getSaldo());
		System.out.println("Saldo de c3: " + c3.getSaldo());
	
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
	
	}

}
