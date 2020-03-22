/**
 * 
 */
package inheritence;

/**
 * @author akashgoyal
 *
 */
public abstract class AbstractClassBank implements BankInterface{

	int deposit;
	int credit;

	public AbstractClassBank(int deposit, int credit) {
		this.credit = credit;
		this.deposit = deposit;
	}

	public void deposit() {
		System.out.println("Common deposit method call:{}" + deposit);
	}

	public void credit() {
		System.out.println("Common credit method call:{}" + credit);
	}

	public abstract int calculateInterest();
}
