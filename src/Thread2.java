public class Thread2 extends Thread {

	public CommonResource commonResource;

	public Thread2(CommonResource commonResource) {
		this.commonResource = commonResource;
	}

	public void run() {
		synchronized (commonResource) {
		while (true) {
			
				System.out.println("Thread2 using lock on commonResource");
				System.out.println("Thread2 is working start:");
				commonResource.get("Thread2");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread2 releasing lock on commonResource");
			}
		}
	}

}
