package education.io.multithreading;

public class TestClassThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShareObject sh1 = new ShareObject();
		Thread1 th1 = new Thread1(sh1);
		Thread2 th2 = new Thread2(sh1);

		th1.start();
		th2.start();

		System.out.println("Both thread start");

	}

}
