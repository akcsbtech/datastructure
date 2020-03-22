/**
 * 
 */
package multithreading;

/**
 * @author akashgoyal
 *
 */
public class Thread1 extends Thread {
	private ShareObject shareObject;

	public Thread1(ShareObject s1) {
		shareObject = s1;
	}

	public void run() {
		try {
			System.out.println("Thread1 start");
			shareObject.m1();
		} catch (Exception ex) {

		}
	}

}
