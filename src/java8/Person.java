package java8;

import java.util.ArrayList;
import java.util.List;

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
	}

	public static void main(String[] args) {
		// Created a list of Person object.
		List<Person> list = new ArrayList<>();
		list.add(new Person("Dave", 23));
		list.add(new Person("Joe", 18));
		list.add(new Person("Ryan", 54));
		list.add(new Person("Iyan", 5));
		list.add(new Person("Ray", 63));

		// We are filtering out those persons whose age is more than 18 and less than 60
		list.stream().filter(person -> person.getAge() > 18 && person.getAge() < 60).forEach(p->System.out.println(p));

		//.forEach(System.out::println);
		
		
		 List<Person> list1 = new ArrayList<>();
	        list1.add(new Person(null, 23));
	        list1.add(new Person("Joe", 18));
	        list1.add(new Person("Ryan", 54));
	        list1.add(new Person("Iyan", 5));
	        list1.add(new Person("Ray", 63));

	        list1.stream()
	                .filter(person -> person.getName() != null ) // Filtering the object where name is not null
	                .filter(person -> person.getAge() > 18 ) // Filtering the objects where age is greater than 18
	                .filter(person -> person.getAge() < 60) // Filtering the objects where age is less than 60
	                .forEach(System.out::println);
	        

	        list1.stream()
	                .filter(person -> person.getName() != null ) // Filtering the object where name is not null
	                .filter(person -> person.getAge() > 18 ) // Filtering the objects where age is greater than 18
	                .filter(person -> person.getAge() < 60) // Filtering the objects where age is less than 60
	                .collect(supplier, accumulator, combiner)
	}

}
