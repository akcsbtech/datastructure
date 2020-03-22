/**
 * 
 */
package java8.lamdaexpression;

/**
 * @author akashgoyal
 *
 */
public class StateOwner {

	public void addStateListener(StateChangeListener listener) {
		System.out.println("addStateListener");
		listener.onStateChange(new State(), new State());
	}

}
