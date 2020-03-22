package java8.lamdaexpression;

public class StringOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String constantString1 = "Baeldung";
		String constantString2 = "Baeldung";
		String newString = new String("Baeldung");
		
		String newString1 = newString.intern();


		System.out.println(constantString1.equals(constantString2));
		System.out.println(constantString1.equals(newString));
		
		System.out.println(constantString1 == (newString));
		
		System.out.println(newString1 == (newString));
		
		System.out.println(newString1 == (constantString1));

		
		

	}

}
