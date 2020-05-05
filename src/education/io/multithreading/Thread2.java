package education.io.multithreading;

public class Thread2 extends Thread {

	private ShareObject shareObject;

	public Thread2(ShareObject s1) {
		shareObject = s1;
	}

	public void run() {
		try {
			System.out.println("Thread2 start");
			shareObject.m2();
		} catch (Exception ex) {

		}
	}
}
