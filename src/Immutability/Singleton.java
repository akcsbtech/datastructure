package Immutability;

public class Singleton {
	private static volatile Singleton _instance;

	public static Singleton getInstance() {
		if (_instance == null) {
			synchronized (Singleton.class) {
				if (_instance == null)
					_instance = new Singleton();
			}
		}
		return _instance;
	}

	public static void main(String[] arg) {
		System.out.println(Singleton.getInstance());
	}
}
