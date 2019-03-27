
public class Conta {
	private String id;
	private double saldo;
	
	protected Conta(String id, double saldo) {
		this.id = id;
		this.saldo = saldo;
	}
	
	protected Conta (String id) {
		this.id = id;
		this.saldo = 0;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public boolean creditar (double valor) {
		boolean operacao = false;
		
		if (valor>0) {
			this.saldo += valor;
			operacao = true;
			System.out.println(this.id + " crédito +" + valor);
		}
		else {
			System.out.println("Não foi possível creditar o valor " + valor);
		}
		return operacao;
	}
	
	public boolean debitar (double valor) {
		boolean operacao = false;
		
		if (valor > 0 && this.saldo >= valor){
			this.saldo -= valor;
			operacao = true;
			System.out.println(this.id + " débito -" + valor);
		}
		else {
			System.out.println("Não foi possível debitar o valor " + valor);
		}
		return operacao;
	}
	
	public boolean transferir (double valor, Conta destino) {
		boolean operacao = false;
		
		System.out.println("========= Transferência ====== ");
		
		if (this.debitar(valor)){
			operacao = destino.creditar(valor);
		}
		System.out.println("============================== ");
		
		return operacao;
	}
}
