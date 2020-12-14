package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ll=new ArrayList<>();
		ll.add("akash");
		ll.add("suraj");
		ll.add("prasant");
		ll.add("samerr");
		
		Stream.of(1,2,3,4,5,6,7).forEach(p-> System.out.print("  "+p));
		ll.stream().forEach(p->System.out.print("  "+p));
		
		System.out.println();
		ll.stream().filter(p->!p.equals("suraj")).forEach(p->System.out.println(p));
		
		ll.stream().forEach(p->System.out.print("  "+p));

	}

	
}
