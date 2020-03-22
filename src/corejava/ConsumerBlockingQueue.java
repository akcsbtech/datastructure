/**
 * 
 */
package corejava;

import java.util.concurrent.BlockingQueue;

/**
 * @author akashgoyal
 *
 */
public class ConsumerBlockingQueue implements Runnable {

	private BlockingQueue sharedQ;

	public ConsumerBlockingQueue(BlockingQueue sharedQ) {
		this.sharedQ = sharedQ;
	}

	public void run() {

		while (true) {
			try {
				System.out.println("Name :" + Thread.currentThread().getName() + " Consume Data :" + sharedQ.take());
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
