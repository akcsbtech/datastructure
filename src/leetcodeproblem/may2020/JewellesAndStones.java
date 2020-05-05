package leetcodeproblem.may2020;

import java.util.HashMap;

class JewellesAndStones {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        int count =0;
        if(J==null){
            return count;
        }
        for(int i=0;i<J.length();i++){
            map.put(J.charAt(i),1);
        }
        
        for(int i=0;i<S.length();i++){
            if(map.get(S.charAt(i))!=null){
                ++count;
            }
        }
        return count;
    }
}