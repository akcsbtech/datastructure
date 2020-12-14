/**
 * 
 */

/**
 * @author b0218163
 *
 */
public class TestException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = null;
		try {
			if (s.equals("null")) {
				System.out.println("Null check pass");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			test(s);
		}
		System.out.println("finish work");
	}

	public static void test(String s) {
		try {
			if (s.equals("null")) {
				System.out.println("Null check pass");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
	}

}
