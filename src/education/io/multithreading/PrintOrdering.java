package education.io.multithreading;

public class PrintOrdering {

	private volatile int flag;

	public PrintOrdering() {
		flag = 1;
	}

	public void printFirst() throws InterruptedException {
		for (;;) {
			if (flag == 1) {
				System.out.println("first");
				flag = 2;
				break;
			}
		}
	}

	public void printSecond() throws InterruptedException {
		for (;;) {
			if (flag == 2) {
				System.out.println("second");
				flag = 3;
				break;
			}
		}
	}

	public void printThird() throws InterruptedException {
		for (;;) {
			if (flag == 3) {
				System.out.println("third");
				flag = 1;
				break;
			}
		}
	}
}
