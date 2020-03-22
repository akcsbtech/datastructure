//Java program to check whether given string 
// is a valid floating point number using regex 

import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

class GFG 
{ 
	public static void main (String[] args) 
	{ 
		String input1 = "10e5.4"; 
		String input2 = "2e10"; 
		
		// regular expression for a floating point number 
		//String regex = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?"; 
		
		// compiling regex 
		//Pattern p = Pattern.compile(regex); 
		
		// Creates a matcher that will match input1 against regex 
		//Matcher m = p.matcher(input1); 
		//String regex = "[+-]?[0-9]+(\\.[0-2]+)?([Ee][+-]?[0-0]+)?"; 

		String value="0000.00";
		String regex="[0-9]+(\\.[0-0][0-0]?)?";
		//String regex="\\d+(\\.\\d{1,2})?";
		System.out.println(Pattern.compile(regex).matcher(value).matches());
		// If match found and equal to input1 
		/*
		 * if(m.find() && m.group().equals(input1)) System.out.println(input1 +
		 * " is a valid float number"); else System.out.println(input1 +
		 * " is not a valid float number");
		 * 
		 * // Creates a matcher that will match input2 against regex m =
		 * p.matcher(input2);
		 * 
		 * // If match found and equal to input2 if(m.find() &&
		 * m.group().equals(input2)) System.out.println(input2 +
		 * " is a valid float number"); else System.out.println(input2 +
		 * " is not a valid float number");
		 */
	} 
} 
