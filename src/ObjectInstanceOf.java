import java.util.HashMap;
import java.util.Map;

public class ObjectInstanceOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		float similarityDist=90;
		double distance=67.03;
		
		System.out.println(" "+(distance >= similarityDist));
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", 1);
		Double d = 10.0;
		map.put("10", d);

		if (map.get("1") instanceof Integer) {
			Integer i = (Integer) map.get("1");
			Double dd1i = Double.valueOf(i + "");
			System.out.println(" i" + i + "  dd1i |" + dd1i);
		} else if (map.get("1") instanceof Double) {
			double dd = (Double) map.get("1");
			System.out.println(" d" + dd);

		}

		if (map.get("10") instanceof Integer) {
			int i = (Integer) map.get("10");
			System.out.println(" i" + i);
		} else if (map.get("10") instanceof Double) {
			double dd = (Double) map.get("10");
			System.out.println(" d" + dd);
		}
	}

}
