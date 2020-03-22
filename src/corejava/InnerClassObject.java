package corejava;

public class InnerClassObject {
	public class Bar{
		public Bar(){
			System.out.println("Bar Object Created");
		}
	}
	
	public static void main(String [] arg) {
		InnerClassObject ico =new InnerClassObject();
		
		
		//Bar bb=new ico.Bar();
	}
}
