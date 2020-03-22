package collection;

public class ReadThread implements Runnable{
	MyCache myCache;

	public ReadThread(MyCache myCache) {
		this.myCache = myCache;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				myCache.put(i +"",i+"");
				myCache.m1(myCache);
				System.out.println("Read myCache |put in: " + i );
				Thread.sleep(100);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

}
