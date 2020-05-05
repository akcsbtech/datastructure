package education.io.multithreading;

public class RunNThreadSequence implements Runnable {
	private static Object lock = new Object();
	private static String var = "x";
	private boolean[] flag;
	private static int count = 0;

	public RunNThreadSequence(int n) {
		flag = new boolean[n];
		if (n > 0) {
			flag[0] = false;
			for (int i = 1; i < n; i++) {
				flag[i] = true;
			}
		}
	}

	public void run() {
		System.out.println("CodeBlock1");
		synchronized (lock) {
			for (int i = 0; i < 5; i++) {
				while (flag[Integer.parseInt(Thread.currentThread().getName())]) {
					try {
						System.out.println("while true for codeBlock1" + i);
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + var + " " + (++count));
				var = "y";
				flag[Integer.parseInt(Thread.currentThread().getName())] = true;
				flag[Integer.parseInt(Thread.currentThread().getName()) + 1] = false;
				lock.notifyAll();
			}
		}
	}
}