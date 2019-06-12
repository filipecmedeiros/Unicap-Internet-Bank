package br.unicap.bank.ui;

import br.unicap.bank.data.AccountsRepository;
import br.unicap.bank.data.IRepAccount;
import br.unicap.bank.data.IRepUser;
import br.unicap.bank.data.UserRepository;
import br.unicap.bank.exceptions.InsuficientBalanceException;
import br.unicap.bank.exceptions.NegativeCreditException;
import br.unicap.bank.exceptions.NegativeDebitException;
import br.unicap.bank.model.AbstractAccount;
import br.unicap.bank.model.CtrlAccount;
import br.unicap.bank.model.CtrlUser;
import br.unicap.bank.model.User;

public class Facade {
	  private static Facade instance;
	  private CtrlAccount account;
	  private CtrlUser user;
	  
	 public static Facade init() {
		 if (instance == null) {
			 instance = new Facade();
		 }
		 return instance;
	 }
	 private Facade() {
		 register();
	 }

	 private void register() {
		 IRepAccount rep = new AccountsRepository(100);
		 account = new CtrlAccount(rep);
	
		 IRepUser repClients = new UserRepository(100);
		 user = new CtrlUser(repClients);
	 }
	 
	 public static Facade getInstance() {
		 return Facade.instance;
	 }
	 
	 //Users
	 public void create(User user) throws Exception {
		 this.user.create(user);
	 }
	  
	 public User readUser(String id) {
		 return user.read(id);
	 }
	  
	 public void update (User user) {
		 this.user.update(user);
	 }

	 public void delete (User user) {
		 this.user.delete(user);
	 }
	  
	 //Accounts
	 public void create (AbstractAccount account) throws Exception {
		 User client = account.getClient();
		 if (client != null) {
			 user.read(client.getCpf());
			 this.account.create(account);
		 } else {
			 System.out.println("cliente nulo");
		 } 
	 }
	  
	 public AbstractAccount readAccount (String s) {
		 return account.read(s);
	 }
	  
	 public void update (AbstractAccount account) {
		 this.account.update(account);
	 }
	  	  
	 public void delete(AbstractAccount account) {
		 this.account.delete(account);
	 }
	  
	 public void credit (String id, double value) throws NegativeCreditException {
		 account.credit(id, value);
	 }
	  
	 public void debitar(String id, double value) throws NegativeDebitException, InsuficientBalanceException {
		 account.debit(id, value);
	 }
	  
	 public void transference(String origin, double value, String destiny) throws NegativeDebitException, InsuficientBalanceException, NegativeCreditException {  
		 account.transference(origin, value, destiny);
	 }
}