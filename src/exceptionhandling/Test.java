/**
 * 
 */
package exceptionhandling;

/**
 * @author akashgoyal
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		A a = new B();
		a.show();
		}catch(Exception ex) {
				ex.printStackTrace();
		}
	}

}
