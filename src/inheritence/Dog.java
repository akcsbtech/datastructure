package inheritence;

class Dog extends Animal {
	String type = "Dog";

	public static void main(String args[]) {
		Dog p = new Dog();
		System.out.println("Name:" + p.name);
		System.out.println("Type:" + p.type);
	}
}