package dpproblem;

public class LCS {

	public static void main(String [] arg) {
		String s1="ABACDEF";
		String s2="ABSACEFD";
		
		byte[]x=s1.getBytes();
		byte[]y=s2.getBytes();

		int lcsoutput=lcs(x,x.length,y,y.length);
		System.out.println("lcsoutput |"+lcsoutput);

	}
	
	public static  int lcs(byte [] x,int m,byte [] y,int n) {
		int  count[][] =new int [m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			count[i][n]=0;
		}
		
		for(int j=0;j<=n;j++) {
			count[m][j]=0;
		}
		
		for(int i=m-1;i>=0;--i) {
			for(int j=n-1;j>=0;--j) {
				count[i][j]=count[i+1][j+1];
				
				if(x[i]==y[j]) {
					++count[i][j];
				}
				
				if(count[i][j+1]>count[i][j]) {
					count[i][j]=count[i][j+1];
				}
				if(count[i+1][j]>count[i][j]) {
					count[i][j]=count[i+1][j];
				}
			}
		}
		
		for(int i=0;i<=m;++i) {
			for(int j=0;j<=n;j++) {
				System.out.print(count[i][j]+"  ");
			}
			System.out.println("");
		}
		return count[0][0];
	}
}
