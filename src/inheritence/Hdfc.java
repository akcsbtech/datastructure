/**
 * 
 */
package inheritence;

/**
 * @author akashgoyal
 *
 */
public class Hdfc extends AbstractClassBank{
	int calculateInterestRate;
	
	public Hdfc(int calculateInterestRate) {
		super(1,2);
	this.calculateInterestRate=	calculateInterestRate;
	}

	@Override
	public int calculateInterest() {
		// TODO Auto-generated method stub
		System.out.println("Hdfc interest calculate..."+calculateInterestRate);
		return calculateInterestRate;
	}

}
