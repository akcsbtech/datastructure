package dpproblem;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int n= s.nextInt();                 // Reading input from STDIN

        Set<Integer> A =new HashSet<Integer>();
        Set<Integer> B =new HashSet<Integer>();
        Set<Integer> C= new HashSet<Integer>();
        
        for(int i=0;i<n;i++){
            A.add(s.nextInt());
        }
        
        n= s.nextInt();  
        for(int i=0;i<n;i++){
            C.add(s.nextInt());
        }
        
        for(Integer c:C) {
        	int minValue=Integer.MAX_VALUE;
        	for(Integer a:A) {
        		int b=c-a;
        		if(b>0 && b<minValue) {
        			minValue=b;
        		}
        	}
        	B.add(minValue);
        }
        
        Set<Integer> finalSet=new HashSet<Integer>();
        Set<Integer> removeSet=new HashSet<Integer>();

        for(Integer a:A) {
        	for(Integer b:B) {
        	
        		if(C.contains((a+b)) && !removeSet.contains(b)) {
        			finalSet.add(b)  ;      		
        		}else {
        			removeSet.add(b);
        		}
        	}
        }
        System.out.println("A |"+A);
        System.out.println("B |"+B);
        System.out.println("C |"+C);
        System.out.println("final |"+finalSet);
        System.out.println("final |"+removeSet);

        

        
       
        //B=A-C;
        

        // Write your code here

    }
}
