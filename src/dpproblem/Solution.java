package dpproblem;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */
    static String findQualifiedNumbers(int[] numberArray) {
        
        int []sortArray= new int [numberArray.length];
        int j=0;
        for(int i=0;i<numberArray.length;i++){
        	boolean oneflag=false;
            boolean twoflag=false;
            boolean threeflag=false;
            int temp=numberArray[i];
            while(temp>0){
                int rem=temp%10;
                temp=temp/10;

                if(rem==1){
                    oneflag=true;
                }else if(rem==2){
                    twoflag=true;
                }else if(rem==3){
                   threeflag=true; 
                }
            }
       
        if(oneflag && twoflag && threeflag){
            sortArray[j]=numberArray[i];
            ++j;
        }
        }
        for(int k=0;k<j;++k){
            for(int l=k+1;l<j;++l){
                if(sortArray[k]>sortArray[l]){
                    int temp1=sortArray[k];
                    sortArray[k]=sortArray[l];
                    sortArray[l]=temp1;
                }
            }
        }

    String result="";
    System.out.println(j);
    for(int p=0;p<j;p++) {
    	 System.out.println(sortArray[p]);
    }
    for(int m=0;m<j;m++){
        if(m==0){
            result=sortArray[m]+"";
        }else{
            result=result+","+sortArray[m];
        }
    }
    return result;
    }
    public static void main(String[] args) throws IOException {
    	int a[] = {10,123,213,456};
    	System.out.println(findQualifiedNumbers(a));
    }
    }