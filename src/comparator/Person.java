/**
 * 
 */
package comparator;

/**
 * @author akashgoyal
 *
 */
public class Person implements Comparable {
	private String name;
	private int salary;

	public Person(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	
	  @Override public int hashCode() {
	  System.out.println("HashCode Method call {}" + this); final int prime = 31;
	  int result = 1; result = prime * result + ((name == null) ? 0 :
	  name.hashCode()); result = prime * result + salary; return result; }
	  
	  @Override public boolean equals(Object obj) {
	  System.out.println("Equals method call {}" + this); if (this == obj) return
	  true; if (obj == null) return false; if (getClass() != obj.getClass()) return
	  false; Person other = (Person) obj; if (name == null) { if (other.name !=
	  null) return false; } else if (!name.equals(other.name)) return false; if
	  (salary != other.salary) return false; return true; }
	 

	@Override
	public String toString() {
		return "Person [name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Person p = (Person) o;
		return salary - p.salary;
	}

}
