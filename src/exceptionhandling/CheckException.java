/**
 * 
 */
package exceptionhandling;

/**
 * @author akashgoyal
 *
 */
public class CheckException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Validator vl = new Validator();
		String[] arg = { "12", "abc1", "abc" };
		for (int i = 0; i < 3; i++) {
			try {
				boolean bl = vl.isValid(arg[i]);
				System.out.println("isValid");
			} catch (StringException st) {
				System.out.println(st.getMessage());
			} catch (AlphaNumericException st) {
				System.out.println(st.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

}
