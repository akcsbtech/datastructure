/**
 * 
 */
package Immutability;

/**
 * @author akashgoyal
 *
 */
public class StringObjectOverring {

	
	public static void main(String [] arg) {
		StringObjectOverring soo=new StringObjectOverring();
		soo.test(null, null);
	}
	public void test(Object o1,Object o2) {
		System.out.println("Object method call");
	}
	
	public void test(String o1,String o2) {
		System.out.println("String method call");
	}
}
