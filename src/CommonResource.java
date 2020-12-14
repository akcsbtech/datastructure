/**
 * 
 */

/**
 * @author b0218163
 *
 */
public class CommonResource {

	public synchronized void get(String s1) {
		System.out.println("Thread using :"+s1);
//		try {
			//while(true) {}
			//Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
