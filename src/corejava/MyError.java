package corejava;

public class MyError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		throwError();
		}catch(Exception ex) {
			ex.printStackTrace();
		}catch(Error e) {
			e.printStackTrace();
		}
		System.out.println("After Throw method call");
	}

	public static void throwError() {
		throw new Error();
	}
}
