
public class ErrorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		badMethod();
		}catch(Exception ex) {
			System.out.println("Exception block call");
		}finally {
			System.out.println("finally block call");
		}
	}
	
	public static void badMethod() {
		throw new Error();
	}

}
