package multithreading;

import java.util.concurrent.CountDownLatch;

public class PrintingThreadUsingCountDownLatch {

	CountDownLatch c1;
	CountDownLatch c2;

	public PrintingThreadUsingCountDownLatch() {
		c1 = new CountDownLatch(1);
		c2 = new CountDownLatch(1);
	}

	public void printFirst() throws InterruptedException {
		System.out.println("First");
		c1.countDown();
	}

	public void printSecond() throws InterruptedException {
		c1.await();
		System.out.println("Second");
		c2.countDown();
	}

	public void printThird() throws InterruptedException {
		c2.await();
		System.out.println("Third");
	}

}
