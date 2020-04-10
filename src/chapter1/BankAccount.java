package chapter1;

public class BankAccount {

	protected String account; // the account number
	protected double balance; // the balance associated with account

	public BankAccount(String acc, double bal)
	// pre: account is a string identifying the bank account
	// balance is the starting balance
	// post: constructs a bank account with desired balance
	{
		account = acc;
		balance = bal;
	}

	public boolean equals(Object other)
	// pre: other is a valid bank account
	// post: returns true if this bank account is the same as other
	{
		BankAccount that = (BankAccount) other;
		// two accounts are the same if account numbers are the same
		return this.account.equals(that.account);
	}

	public String getAccount()
	// post: returns the bank account number of this account
	{
		return account;
	}

	public double getBalance()
	// post: returns the balance of this bank account
	{
		return balance;
	}

	public void deposit(double amount)
	// post: deposit money in the bank account
	{
		balance = balance + amount;
	}

	public void withdraw(double amount)
	// pre: there are sufficient funds in the account
	// post: withdraw money from the bank account
	{
		balance = balance - amount;
	}

	public static void main(String[] args) {
		// Question: is it better to invest $100 over 10 years at 5%
		// or to invest $100 over 20 years at 2.5% interest?
		BankAccount jd = new BankAccount("Jain Dough", 100.00);
		BankAccount js = new BankAccount("Jon Smythe", 100.00);
		for (int years = 0; years < 10; years++) {
			jd.deposit(jd.getBalance() * 0.05);
		}
		for (int years = 0; years < 20; years++) {
			js.deposit(js.getBalance() * 0.025);
		}
		System.out.println("Jain invests $100 over 10 years at 5%.");
		System.out.println("After 10 years " + jd.getAccount() + " has $" + jd.getBalance());
		System.out.println("Jon invests $100 over 20 years at 2.5%.");
		System.out.println("After 20 years " + js.getAccount() + " has $" + js.getBalance());
	}
}
