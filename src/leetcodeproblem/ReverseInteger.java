package leetcodeproblem;
class ReverseInteger {
	public static void main(String [] arg) {
		System.out.println(reverse(1534236469));
	}
    public static  int reverse(int x) {
    	System.out.println(x);
        boolean minus=false;
        if(x<0){
            minus=true;
            x=x*(-1);
        }
        
        int reverse=0;
        int rem=0;
        int div=0;
        while(x>0){
        	System.out.println(reverse);
            rem=x%10;
            x=x/10;
            reverse=reverse*10+rem;
            if((reverse*10/10)!=reverse){
                return 0;
            }
        }
        
        if(minus){
            return (-1)*reverse;
        }else{
            return reverse;
        }
    }
}