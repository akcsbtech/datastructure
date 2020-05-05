package education.io.multithreading;

public class ThreadJoin extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadJoin t1 = new ThreadJoin();
		System.out.println(t1);
		ThreadJoin t2 = new ThreadJoin(t1);
	}

	ThreadJoin t1;

	public ThreadJoin() {

	}

	public ThreadJoin(ThreadJoin t) {
		this.t1 = t;
		System.out.println(t1);
		t1.start();
	}

	public void run() {
		try {
			System.out.println("T1 " + t1);
			t1.join();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception method call");
		} finally {
			System.out.println("finally method call");
		}
	}
}
