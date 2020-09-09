import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author b0218163
 *
 */
public class MapStringToMapObj {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String,String> map=new HashMap<String,String>();
		
		map.put("Hello","1");
		
		Map<String,Object> map2=new HashMap<>(map);
		
		System.out.println(map+"    "+map2);
		
	}

}
