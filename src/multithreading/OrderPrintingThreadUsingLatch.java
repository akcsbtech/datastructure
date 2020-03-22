package multithreading;

public class OrderPrintingThreadUsingLatch extends Thread {
	private PrintingThreadUsingCountDownLatch po;
	private String method;

	public OrderPrintingThreadUsingLatch(PrintingThreadUsingCountDownLatch po, String method) {
		this.po = po;
		this.method = method;
	}

	public void run() {
		if ("first".equals(method)) {
			try {
				po.printFirst();
			} catch (InterruptedException ie) {

			}
		} else if ("second".equals(method)) {
			try {
				po.printSecond();
			} catch (InterruptedException ie) {
			}
		} else if ("third".equals(method)) {
			try {
				po.printThird();
			} catch (InterruptedException ie) {

			}
		}
	}
}
