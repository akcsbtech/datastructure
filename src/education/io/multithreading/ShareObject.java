package education.io.multithreading;

public class ShareObject {

	public synchronized void m1() {
		try {
			System.out.println("M1 method call");
			Thread.sleep(10000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized void m2() {
		try {
			System.out.println("M2 method call");
			Thread.sleep(10000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
