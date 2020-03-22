/**
 * 
 */
package inheritence;

/**
 * @author akashgoyal
 *
 */
public class Icici extends AbstractClassBank {

	int calculateInterestRate;

	public Icici(int calculateInterestRate) {
		super(10,20);
		this.calculateInterestRate = calculateInterestRate;
	}

	@Override
	public int calculateInterest() {
		// TODO Auto-generated method stub
		System.out.println("Icici bank calculate interest"+calculateInterestRate);
		return 0;
	}

}
