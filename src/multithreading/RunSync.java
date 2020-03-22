package multithreading;

public class RunSync {
	public static void main(String[] args) {
		Shared sh = new Shared();
		Shared sh1 = new Shared();
		CustomThread1 t2 = new CustomThread1(sh, "two");

		CustomThread t1 = new CustomThread(sh, "one");
		
	}
}
