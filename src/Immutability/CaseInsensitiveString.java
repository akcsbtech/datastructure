package Immutability;

import java.util.ArrayList;
import java.util.List;

public final class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		if (s == null)
			throw new NullPointerException();
		this.s = s;
	}
	
	/*
	 * public boolean equals(Object o) {
	 * System.out.println("Equals Mehtod call :{}"+o); if(o instanceof
	 * CaseInsensitiveString) return
	 * s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
	 * 
	 * 
	 * if(o instanceof String) { return s.equalsIgnoreCase((String)o); }
	 * 
	 * return false; }
	 */
	@Override
	public boolean equals(Object o) {
		System.out.println("Equals Mehtod call :{}"+o);
		 // if(o instanceof CaseInsensitiveString) return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
		  if(o instanceof String) { return s.equalsIgnoreCase((String)o); }
		return o instanceof CaseInsensitiveString && ((CaseInsensitiveString)o).s.equalsIgnoreCase(s);
		  //return false;
		 
	}
	
	@Override
	public String toString() {
		return "CaseInsensitiveString [s=" + s + "]";
	}

	public static void main(String []arg) {
		CaseInsensitiveString cs=new CaseInsensitiveString("Polish");
		String s="polish";
		
		System.out.println(cs.equals(s));
		System.out.println(s.equals(cs));

		List<CaseInsensitiveString> list=new ArrayList<CaseInsensitiveString>();
		list.add(cs);
		
		System.out.println(list.contains(s));
	}
}
