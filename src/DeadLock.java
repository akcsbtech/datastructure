/**
 * 
 */

/**
 * @author b0218163
 *
 */
public class DeadLock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CommonResource cr=new CommonResource();
		Thread1 t1=new Thread1(cr);
		Thread2 t2=new Thread2(cr);
		System.out.println("start thread 1");
		t1.start();
		
		System.out.println("start thread 2");
		t2.start();
		
		

	}

}
