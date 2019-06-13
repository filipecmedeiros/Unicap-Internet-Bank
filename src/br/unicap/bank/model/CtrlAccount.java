package br.unicap.bank.model;

import br.unicap.bank.data.IRepAccount;
import br.unicap.bank.exceptions.InsuficientBalanceException;
import br.unicap.bank.exceptions.NegativeCreditException;
import br.unicap.bank.exceptions.NegativeDebitException;

public class CtrlAccount extends Controller <AbstractAccount>{
	
	public CtrlAccount(IRepAccount rep) {
		super(rep);
	}
	
	public void credit (String id, double value) throws NegativeCreditException {
		AbstractAccount account = this.read(id);
		account.credit(value);
		this.update(account);
	}
	
	public void debit (String id, double value) throws NegativeDebitException, InsuficientBalanceException {
		AbstractAccount account = this.read(id);
		account.debit(value);
		this.update(account);
	}
	
	public void transference (String origin, double value, String destiny) throws NegativeDebitException, InsuficientBalanceException, NegativeCreditException {
		AbstractAccount o = this.read(origin);
		AbstractAccount d = this.read(destiny);
		o.transference(value, d);
		this.update(o);
		this.update(d);
	}
}
