/**
 * 
 */
package corejava;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author akashgoyal
 *
 */
public class ProducerConsumerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * final Queue sharedQ = new LinkedList<Integer>(); Thread consumerThread = new
		 * Thread(new Consumer(sharedQ, 4), "CONSUMER"); Thread producerThread = new
		 * Thread(new Producer(sharedQ, 4), "PRODUCER"); consumerThread.start();
		 * producerThread.start();
		 */

		final BlockingQueue sharedQ = new LinkedBlockingQueue<Integer>();
		Thread consumerThread = new Thread(new ConsumerBlockingQueue(sharedQ), "CONSUMER");
		Thread consumerThread2 = new Thread(new ConsumerBlockingQueue(sharedQ), "CONSUMER2");
		Thread producerThread = new Thread(new ProducerBlockingQueue(sharedQ), "PRODUCER");
		consumerThread.start();
		consumerThread2.start();
		producerThread.start();

	}

}
