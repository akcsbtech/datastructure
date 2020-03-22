/**
 * 
 */
package singleton;

import java.io.Serializable;

/**
 * @author akashgoyal
 *
 */
public class Singleton implements Serializable {

	private static Singleton INSTANCE = null;
	private int value;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	protected Object readResolve() {
		System.out.println("ReadResolve method call");
		return INSTANCE;
	}
}
