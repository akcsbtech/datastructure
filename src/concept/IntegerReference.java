package concept;

public class IntegerReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 10;
		temp(i);
		System.out.println(i);
	}

	public static void temp(Integer i) {
		i = 20;
	}

}
