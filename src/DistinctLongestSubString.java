import java.util.ArrayList;
import java.util.List;

public class DistinctLongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		DistinctLongestSubString distinctLongestSubString=new DistinctLongestSubString();
		List<String> list=distinctLongestSubString.distinctCommonLogestSubstring("abvbcasde");
		System.out.println("SubString :{}"+list);
	}
	
	public List<String> distinctCommonLogestSubstring(String fullString){
		List<String> list=new ArrayList<String>();
		String currentString="";
		int lengthString=0;
		String prevSubString="";
		char [] cc=fullString.toCharArray();
		int start=cc.length;
		for(int i=fullString.length()-1;i>=0;i--) {
			
			if(duplicateCharacter(cc[i],currentString)) {
				
				if(currentString.length()>prevSubString.length()) {
					list.clear();
					list.add(currentString);
					prevSubString=currentString;
				}else if(currentString.length()==prevSubString.length()) {
					list.add(currentString);
				}
				currentString="";
			}
			else {
				System.out.println(currentString);
				currentString=cc[i]+currentString;
			}
		}
		return list;
	}

	public boolean duplicateCharacter(char cc, String str) {
		char [] chararray=str.toCharArray();
		
		for(int i=0;i<chararray.length;i++) {
			if(chararray[i]==cc)
			{
				return true;
			}
		}
		return false;
	}
}
