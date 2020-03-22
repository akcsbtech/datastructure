/**
 * 
 */
package java8.lamdaexpression;

/**
 * @author akashgoyal
 *
 */
public interface StateChangeListener {

	public void onStateChange(State oldState, State newState);

}
