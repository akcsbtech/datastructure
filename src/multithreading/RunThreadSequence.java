package multithreading;

public class RunThreadSequence {
	private static Object lock = new Object();
	private static String var = "x";
	private static boolean flag1 = false;
	private static boolean flag2 = true;
	private static boolean flag3 = true;
	private static int count=0;
	public static void codeBlock1() {
		System.out.println("CodeBlock1");
		synchronized (lock) {
			for (int i = 0; i < 5; i++) {
				while (flag1) {
					try {
						System.out.println("while true for codeBlock1"+i);
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + var+" "+(++count));
				var = "y";
				flag1 = true;
				flag2 = false;
				flag3 = true;
				lock.notifyAll();
			}
		}
	}

	public static void codeBlock2() {
		System.out.println("CodeBlock2");
		synchronized (lock) {
			for (int i = 0; i < 5; i++) {
				while (flag2) {
					try {
						System.out.println("while true for codeBlock2"+i);
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + var+" "+(++count));
				var = "z";
				flag1 = true;
				flag2 = true;
				flag3 = false;
				lock.notifyAll();
			}
		}
	}

	public static void codeBlock3() {
		System.out.println("CodeBlock3");
		synchronized (lock) {
			for (int i = 0; i < 5; i++) {
				while (flag3) {
					try {
						System.out.println("while true for codeBlock3"+i);
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + var+" "+(++count));
				var = "x";
				flag1 = false;
				flag2 = true;
				flag3 = true;
				lock.notifyAll();
			}
		}
	}

	public static Runnable code() {
		return () -> {
			codeBlock1();
		};
	}

	public static Runnable code2() {
		return () -> {
			codeBlock2();
		};
	}

	public static Runnable code3() {
		return () -> {
			codeBlock3();
		};
	}

	public static void main(String[] args) {
		new Thread(code(), "t1").start();
		new Thread(code2(), "t2").start();
		new Thread(code3(), "t3").start();
	}
}