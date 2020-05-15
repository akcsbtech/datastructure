package stringmanuplation;

public class LongestPlaindromicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPlaindrome("aba"));
		
		System.out.println(longestPlaindrome("aabaaaaa"));
		
	}
	
	public static String longestPlaindrome(String s) {
		if(s==null || s.length()<=1) {
			return s;
		}
		int len=s.length();
		int maxlen=1;
		boolean [][] dp=new boolean[len][len];
		String longestS=null;
		
		for(int i=0;i<len;i++) {
			for(int j=0;j<len-i;j++) {
				int k=i+j;
				
				if(s.charAt(j)==s.charAt(k)  &&( k-j <=2 || dp[j+1][k-1])) {
					dp[j][k]=true;
					
					if(k-j+1>maxlen) {
						maxlen=k-j+1;
						longestS=s.substring(j,k+1);
					}
				}
			}
		}
		return longestS;
	}

}
