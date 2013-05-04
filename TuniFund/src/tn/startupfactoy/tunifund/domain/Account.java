package tn.startupfactoy.tunifund.domain;

public class Account {

	public String id;
	public double amount;
	
	
	
	public Account() {
		super();
	}

	public Account(String id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
