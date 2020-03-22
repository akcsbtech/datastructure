/**
 * 
 */
package collection;

/**
 * @author akashgoyal
 *
 */
public class InfiniteLoopProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCache myCache=new MyCache();
		Thread rt=new Thread(new ReadThread(myCache));
		Thread wt=new Thread(new WriteThread(myCache));
		rt.start();
		wt.start();

	}

}
