package corejava;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
	private final Queue sharedQ;
	private int maxSize;

	public Producer(Queue sharedQ, int size) {
		this.sharedQ = sharedQ;
		this.maxSize = size;
	}

	public void run() {
		while (true) {
			synchronized (sharedQ) {
				while (sharedQ.size() == maxSize) {
					try {
						System.out.println("Queue is full");
						sharedQ.wait();
					} catch (InterruptedException ie) {

					}
				}
				Random rnd = new Random();
				int number = rnd.nextInt();
				System.out.println("Produced number :" + number);
				sharedQ.add(number);
				sharedQ.notify();
			}
		}
	}
}
