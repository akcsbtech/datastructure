/**
 * 
 */

/**
 * @author b0218163
 *
 */
public class RemoveSirName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Mr, Mrs, Dr, Miss, Ms, Rev, Mr. , Mr. , Dr. , Miss. , Ms. , Rev. , Mr . , Mr . , Dr . , Miss . , Ms . , Rev .
		String name="Mr . akaMrsh goyal";
		String patternStr="(?i)^\\s*(?:M(?:iss|rs?|s)|Dr|Rev)\\b[\\s.]*";
		String newName = name.replaceAll("\\s{2,}", " ").replaceFirst(patternStr, "").trim();

		System.out.println(newName);

	}

}
