
public class Account {
	private String id;
	private double balance;
	
	protected Account(String id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	protected Account (String id) {
		this.id = id;
		this.balance = 0;
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
	
	public boolean credit (double valor) {
		boolean operacao = false;
		
		if (valor>0) {
			this.balance += valor;
			operacao = true;
			System.out.println(this.id + " crédito +" + valor);
		}
		else {
			System.out.println("Não foi possível creditar o valor " + valor);
		}
		return operacao;
	}
	
	public boolean debit (double valor) {
		boolean operacao = false;
		
		if (valor > 0 && this.balance >= valor){
			this.balance -= valor;
			operacao = true;
			System.out.println(this.id + " débito -" + valor);
		}
		else {
			System.out.println("Não foi possível debitar o valor " + valor);
		}
		return operacao;
	}
	
	public boolean transferir (double valor, Account destino) {
		boolean operacao = false;
		
		System.out.println("========= Transferência ====== ");
		
		if (this.debit(valor)){
			operacao = destino.credit(valor);
		}
		System.out.println("============================== ");
		
		return operacao;
	}
}
