package completablefuture;

public class IntegerComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer a = 127;
		Integer b = 127;
		Integer c = 128;
		Integer d = 128;

		char ch = 'a';
		char ch1 = 'a';
		System.out.println(a == b);
		System.out.println(c == d);
		System.out.println(ch==ch1);
		
		System.out.println("--------------");
		/*
		 * Integer x = Integer.parseInt("130"); Integer m = Integer.parseInt("1");
		 * Integer n = Integer.parseInt("1"); Integer y = Integer.parseInt("130");
		 * 
		 * System.out.println(x==y); System.out.println(m==n);
		 */
		
		Integer x = Integer.valueOf("130");
		Integer m = Integer.valueOf("1");
		Integer n = Integer.valueOf("1");
		Integer y = Integer.valueOf("130");
		Integer aaa = new Integer(1);
		Integer aab = new Integer(1);
		
		System.out.println(x==y);
		System.out.println(m==n);
		System.out.println(aaa==aab);


	}

}
