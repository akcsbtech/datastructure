package exceptionhandling;

public class Binding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Dog();
		callEat(a);
	}

	public static void callEat(Animal animal) {
		System.out.println("Animal is eating");
	}

	public static void callEat(Dog dog) {
		System.out.println("Dog is eating");
	}
}
