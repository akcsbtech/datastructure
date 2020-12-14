import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatch {

	public static void main(String [] arg) {
		
		String settlementAccountName="0";
		String bankNamePattern="[0-9]";
		
		Boolean abc=Pattern.compile(bankNamePattern).matcher(settlementAccountName).find();
		System.out.println(abc);
		
		
		String regex="^[1-9][0-9]{5}$";
		String stringToValidate="923456";
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(stringToValidate);
		System.out.println(matcher.matches());
	}
}
