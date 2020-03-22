/**
 * 
 */
package corejava;

import java.util.Queue;

/**
 * @author akashgoyal
 *
 */
public class Consumer implements Runnable {

	private final Queue sharedQ;
	private int maxSize;

	public Consumer(Queue sharedQ, int maxSize) {
		this.sharedQ = sharedQ;
		this.maxSize = maxSize;
	}

	public void run() {
		while (true) {
			synchronized (sharedQ) {
				while (sharedQ.isEmpty()) {
					try {
						System.out.println("Queue is empty");
						sharedQ.wait();
					} catch (InterruptedException ie) {
					}
				}
				int number = (Integer) sharedQ.poll();
				System.out.println("Removing Element :" + number);
				sharedQ.notify();

			}
		}
	}
}
