package leetcodeproblem.may2020;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// d2[abc]
		//System.out.println(decodeString("d2[abc]"));
		//System.out.println(decodeString("3[a]2[bc]"));
		
		System.out.println(decodeString("3[acc]"));
		//System.out.println(decodeString("2[abc]3[cd]ef"));

	}

	public static String decodeString(String input) {
		String output = "";

		Stack<Integer> intStack = new Stack<>();
		Stack<Character> charStack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			int count = 0;
			if (Character.isDigit(input.charAt(i))) {
				while (Character.isDigit(input.charAt(i))) {
					count = count * 10 + input.charAt(i) - '0';
					++i;
				}
				--i;

				if (count > 0)
					intStack.push(count);
			} else if (input.charAt(i) == ']') {
				
				String s = "";
				while(!charStack.isEmpty()) {
				while (!charStack.isEmpty()) {
					if (charStack.peek() == '[') {
						charStack.pop();
						break;
					} else {
						s = charStack.pop()+s;
					}
				}

				if (!s.equals("")) {
					int t = intStack.pop();

					for (int j = 0; j < t; j++)
						output = output + s;
					
					System.out.println("s :"+s+"  "+i+"   t:"+t);
				}
				
			}
				
			} else if(!charStack.isEmpty() || input.charAt(i)=='['){
				charStack.push(input.charAt(i));
			}else {
				output=output+input.charAt(i);
			}

		}
		return output;
	}
	
	public String decodeString1(String s){
		Stack<Integer> countStack = new Stack<>();
		Stack<String> encStack = new Stack<>();
		int index = 0;
		String res = "";
		while(index < s.length()){
			char c = s.charAt(index);
			if(Character.isDigit(c)){
				int count = 0;
				while(index < s.length() && Character.isDigit(s.charAt(index))){
					count = 10 * count + (s.charAt(index) - '0');
					index++;
				}
				countStack.push(count);
			} else if(c == '['){
				encStack.push(res);
				res = ""; //reset
				index++;
			}  else if(c == ']'){
				StringBuilder temp = new StringBuilder(encStack.pop());
				int count = countStack.pop();
				for(int i = 0; i<count; i++){
					temp.append(res);
				}
				res = temp.toString();
				index++;
			} else {
				res += c;
				index++;
			}
		}
		System.out.println("Enc = "+s +", Decoded  = "+res);
		return res;
	}

}
