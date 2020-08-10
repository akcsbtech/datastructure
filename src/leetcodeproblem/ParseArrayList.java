package leetcodeproblem;

import java.util.Stack;

class ParseArrayList {
	public static void main(String [] arg) {
		ParseArrayList ps=new ParseArrayList();	
		NestedInteger ni=ps.deserialize("324");
		
		while(ni!=null)
		{
			System.out.println(ni.value);
			ni=ni.ns;
		}
		
		ni=ps.deserialize("[123,[456,[789]]]");
		
		while(ni!=null)
		{
			System.out.println(ni.value);
			ni=ni.ns;
		}
	}
	private boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}

	public NestedInteger deserialize(String s) {
		if (!s.startsWith("[")) {
			return new NestedInteger(Integer.valueOf(s));
		}

		Stack<NestedInteger> stk = new Stack<>();

		char[] chs = s.toCharArray();
		int ret = 0;
		int sign = 1;
		NestedInteger ni;
		for (int i = 0; i < chs.length; i++) {
			switch (chs[i]) {
			case '[':
				ni = new NestedInteger();
				if (stk.size() > 0) {
					stk.peek().add(ni);
				}
				stk.push(ni);
				break;
			case ']':
				ni = stk.pop();
				if (isDigit(chs[i - 1])) {
					ni.add(new NestedInteger(ret * sign));
					sign = 1;
					ret = 0;
				}
				if (i == chs.length - 1) {
					return ni;
				}
				break;
			case '-':
				sign = -1;
				break;
			case ',':
				if (isDigit(chs[i - 1])) {
					stk.peek().add(new NestedInteger(ret * sign));
					sign = 1;
					ret = 0;
				}
				break;
			default:
				ret = ret * 10 + (int) (chs[i] - '0');
			}
		}

		return null;
	}
}