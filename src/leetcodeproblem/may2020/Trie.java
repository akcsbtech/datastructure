package leetcodeproblem.may2020;
class Trie {

public static void main(String [] arg) {
	Trie obj = new Trie();
	 obj.insert("apple");
	 boolean param_2 = obj.search("apple");
	 System.out.println(param_2);
	  boolean param_3 = obj.startsWith("app");
	  boolean param_4 = obj.startsWith("xyz");
	  
	 System.out.println(param_2 +" "+param_3+"  "+param_4);
    }
    /** Initialize your data structure here. */
    Trie root;
    Trie[] next;
    Boolean isEnd=false;
    public Trie() {
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	if(root==null)
    		root=new Trie();
        Trie temp=root;
        for(int i=0;i<word.length();i++){
            if(temp.next!=null && temp.next[word.charAt(i)-97]!=null){
                temp=temp.next[word.charAt(i)-97];
            }else{
                //create node
                if(temp.next==null){
                    temp.next=new Trie[26];
                }
                System.out.println(word.charAt(i)+"  "+(word.charAt(i)-97));
                temp.next[word.charAt(i)-97]=new Trie();
                temp=temp.next[word.charAt(i)-97];
            }
        
        if(i==word.length()-1){
            temp.isEnd=true;
        }
    }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
         Trie temp=root;
        for(int i=0;i<word.length();i++){
             if(i==word.length()-1 && temp.next!=null && temp.next[word.charAt(i)-97].isEnd){
            	 return true;
        }
             if(temp.next!=null && temp.next[word.charAt(i)-97]!=null){
                temp=temp.next[word.charAt(i)-97];
            }else{
                 return false;
             }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      Trie temp=root;
        for(int i=0;i<prefix.length();i++){
             if(i==prefix.length()-1 && temp!=null &&temp.next!=null ){
          return true;
        }
             if(temp.next!=null && temp.next[prefix.charAt(i)-97]!=null){
                temp=temp.next[prefix.charAt(i)-97];
            }else{
                 return false;
             }
        }
        return true;
    }
    
}