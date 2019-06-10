package br.unicap.bank.model;

import br.unicap.bank.data.IRepAbstractAccount;
import br.unicap.bank.exceptions.InsuficientBalanceException;
import br.unicap.bank.exceptions.NegativeCreditException;
import br.unicap.bank.exceptions.NegativeDebitException;

public class CtrlAbstractAccount {
	private IRepAbstractAccount accounts;
	
	public CtrlAbstractAccount(IRepAbstractAccount rep) {
		this.accounts = rep;
	}

	public void create (AbstractAccount account) throws Exception {
		if (!accounts.exists(account)) {
			accounts.create(account);
		}
		else {
			throw new Exception();
		}
	}
	
	public void read (String id) {
		accounts.read(id);
	}
	
	public void update (AbstractAccount account) {
		accounts.update(account);
	}
	
	public void delete (AbstractAccount account) {
		accounts.delete(account);
	}
	
	public void credit (String id, double value) throws NegativeCreditException {
		AbstractAccount account = accounts.read(id);
		account.credit(value);
		accounts.update(account);
	}
	
	public void debit (String id, double value) throws NegativeDebitException, InsuficientBalanceException {
		AbstractAccount account = accounts.read(id);
		account.debit(value);
		accounts.update(account);
	}
	
	public void transference (String origin, double value, String destiny) throws NegativeDebitException, InsuficientBalanceException, NegativeCreditException {
		AbstractAccount o = accounts.read(origin);
		AbstractAccount d = accounts.read(destiny);
		o.transference(value, d);
		accounts.update(o);
		accounts.update(d);
	}
}
