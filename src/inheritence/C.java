package inheritence;

public class C extends V{

	@Override
	public void fun1() {
		// TODO Auto-generated method stub
		
		System.out.println("Dog");
		
	}
	
	public void fun2() {
		// TODO Auto-generated method stub
		super.fun1();
		
	}
	
	
	
	
	public static void main(String [] arg) {
		
		A a=new C();
		C c=new C();
		
		a.fun1();
		c.fun2();
	}
}
