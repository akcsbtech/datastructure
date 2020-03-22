package inheritence;

public class MainMethod {
	public static void main(String [] arg) {
		AbstractClassBank hdfc=new Hdfc(1);
		hdfc.deposit();
		hdfc.credit();
		hdfc.calculateInterest();
		AbstractClassBank icici=new Icici(2);
		icici.deposit();
		icici.credit();
		icici.calculateInterest();
		
		//AbstractClassBank acs=new AbstractClassBank(1,2);
	}

}
