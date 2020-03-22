package collection;

public class WriteThread implements Runnable {

	MyCache myCache;

	public WriteThread(MyCache myCache) {
		this.myCache = myCache;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Write myCache |i: " + i + " value:" + myCache.get(i + ""));
				myCache.m2(myCache);
				Thread.sleep(100);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

}
