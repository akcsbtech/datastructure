package leetcodeproblem;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(4));
		System.out.println(reverseBits(-3));

	}

	public static int reverseBits(int n) {
		 System.out.println(n);
	       StringBuilder input1 = new StringBuilder();
		        String bitmask = Integer.toBinaryString(n);
		        int len=bitmask.length();
	         for(int i=0;i<32-len;i++)
		        	bitmask="0"+bitmask;	
		        input1.append(bitmask);
	          System.out.println(bitmask);
		        input1 = input1.reverse(); 
	        System.out.println(input1);
		    int output= Integer.parseInt(input1.toString(), 2);
	        System.out.println(output);
	        return output;
	      
    }
}
