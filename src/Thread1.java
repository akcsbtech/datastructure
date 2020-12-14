
public class Thread1 extends Thread {

	public CommonResource commonResource;

	public Thread1(CommonResource commonResource) {
		this.commonResource = commonResource;
	}

	public void run() {
		synchronized (commonResource) {
		while (true) {
			
				System.out.println("Thread1 using lock on commonResource");
				System.out.println("Thread1 is working");
				commonResource.get("Thread1");
				try {

					Thread.sleep(10000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread1 releasing lock on commonResource");
			}

		}
	}

}
