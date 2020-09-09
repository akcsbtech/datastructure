package leetcodeproblem.may2020;

public class RepeatedSubStringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(repeatedSubstringPattern("abab"));

	}
	
	public static boolean repeatedSubstringPattern(String s) {
        String pattern="";
        if(s==null || s.equals(""))
            return false;
        pattern=s.charAt(0)+"";
    for(int i=1;i<s.length();i++){
        if(s.charAt(i)==pattern.charAt(0)){
            break;
        }
        pattern=pattern+s.charAt(i);
    }
        
    String t=s.replace(pattern, "");
    
    if(t.length()==0)
    	return true;
    else 
    	return false;
    }

}
