import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 
 */

/**
 * @author b0218163
 *
 */
public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DecimalFormat df2 = new DecimalFormat("#.##");
		 
		 NumberFormat numberFormatter = new DecimalFormat("##.00");
		 
		 Double totalConsultingFee = 7.1264;
		 
		 System.out.println(df2.format(totalConsultingFee));
		 
		 System.out.println(numberFormatter.format(totalConsultingFee));

	}

}
