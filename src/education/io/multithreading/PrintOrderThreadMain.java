package education.io.multithreading;

public class PrintOrderThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintOrdering po = new PrintOrdering();
		OrderPrintingThread t1 = new OrderPrintingThread(po, "first");
		OrderPrintingThread t2 = new OrderPrintingThread(po, "second");
		OrderPrintingThread t3 = new OrderPrintingThread(po, "third");

		t2.start();
		t3.start();
		t1.start();

		PrintingThreadUsingCountDownLatch po1 = new PrintingThreadUsingCountDownLatch();
		OrderPrintingThreadUsingLatch t11 = new OrderPrintingThreadUsingLatch(po1, "first");
		OrderPrintingThreadUsingLatch t12 = new OrderPrintingThreadUsingLatch(po1, "second");
		OrderPrintingThreadUsingLatch t13 = new OrderPrintingThreadUsingLatch(po1, "third");

		t12.start();
		t13.start();
		t11.start();
	}

}
