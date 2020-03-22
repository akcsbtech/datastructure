package Immutability;

public enum SingleDesignPattern {

	INSTANCE;
	private int count;

	public void setCount(int count) {
		this.count = count;
	}

	public void doProcess() {
		System.out.println("Do high memory or CPU consume operation :-" + this.count);
	}

	public static void main(String[] arg) {
		SingleDesignPattern.INSTANCE.doProcess();

		SingleDesignPattern.INSTANCE.setCount(1);
		SingleDesignPattern.INSTANCE.setCount(2);
		SingleDesignPattern.INSTANCE.doProcess();
		SingleDesignPattern.INSTANCE.doProcess();
		SingleDesignPattern.INSTANCE.doProcess();
	}

	public static Singleton getInstance() {
		if (obj == null) {
			// To make thread safe
			synchronized (Singleton.class) {
				// check again as multiple threads
				// can reach above step
				if (obj == null)
					obj = new Singleton();
			}
		}
		return obj;
	}
}
