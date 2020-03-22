/**
 * 
 */
package corejava;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author akashgoyal
 *
 */
public class ProducerBlockingQueue implements Runnable {

	private BlockingQueue sharedQ;

	public ProducerBlockingQueue(BlockingQueue sharedQ) {
		this.sharedQ = sharedQ;
	}

	public void run() {
		while (true) {
			try {
				Random rd = new Random();
				int next = rd.nextInt();
				System.out.println("Name :" + Thread.currentThread().getName() + "produce Value :" + next);
				sharedQ.put(next);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
