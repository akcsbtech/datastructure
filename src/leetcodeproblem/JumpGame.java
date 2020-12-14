/**
 * 
 */
package leetcodeproblem;

/**
 * @author b0218163
 *
 */
public class JumpGame {

	public static void main(String [] arg) {
		
	}
	
	public boolean isPossibleToReachZero(int [] arr,int start) {
		
		return false;
	}
	
	public boolean helper(int [] arr,int left,int right) {
		if(arr[left]==0) {
			return true;
		}
		if(arr[right]==0) {
			return true;
		}
		
		helper(arr,left-arr[left]);
		
	}
}
