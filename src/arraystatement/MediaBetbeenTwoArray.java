/**
 * 
 */
package arraystatement;

/**
 * @author akashgoyal
 *
 */
public class MediaBetbeenTwoArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int median(int[] a, int alo, int ahi, int[] b, int blo, int bhi) {

		int amid, bmid;
		int amed, bmed;
		amid = alo + (ahi - alo) / 2;
		bmid = blo + (bhi - blo) / 2;

		amed = a[amid];
		bmed = b[bmid];

		if (amed == bmed) {
			return amed;
		} else if (ahi - alo +  bhi-blo < 4) {
			
		} else if (amed < bmed) {
			return median(a, amid + 1, ahi, b, blo, bmid);
		} else {
			return median(a, alo, amid, b, bmid, bhi);
		}
	}

}
