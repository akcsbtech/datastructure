package education.io.multithreading;

class Shared {
	static int x;

	synchronized void show(String s, int a) {
		x = a;
		System.out.println("Starting in method " + s + " " + x);
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		System.out.println("Ending from method " + s + " " + x);
	}

	 static synchronized void show1(String s, int a) {
		x = a;
		System.out.println("Starting show1 " + s);
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		System.out.println("Ending from show1 " + s);
	}
}