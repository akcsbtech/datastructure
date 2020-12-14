public class RemoveSpecialCharacterExample1 {
	public static void main(String args[]) {
		//String str = "This#string%contains^special*character s&.";
		String str = "JYOTHI goya@";
		str = str.replaceAll("[^a-zA-Z0-9\\s]", "");
		System.out.println(str);
	}
}