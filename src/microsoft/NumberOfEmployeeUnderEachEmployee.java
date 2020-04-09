package microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfEmployeeUnderEachEmployee {

	static Map<String, Integer> result = new HashMap<String, Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] emp = { { "A", "C" }, { "B", "C" }, { "C", "F" }, { "D", "E" }, { "E", "F" }, { "F", "F" } };

		Map<String, Integer> result = findEmployeeMap(emp);
		System.out.println(result);
	}

	public static Map<String, Integer> findEmployeeMap(String[][] emp) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < emp.length; i++) {
			if (!emp[i][0].equals(emp[i][1])) {
				map.put(emp[i][0], map.getOrDefault(emp[i][0], 0));
				map.put(emp[i][1], map.getOrDefault(emp[i][0], 0) + map.getOrDefault(emp[i][1], 0) + 1);
				System.out.println(map);
			}
		}
		return map;
	}

	// This function populates 'result' for given input 'dataset'
	private static void populateResult(Map<String, String> dataSet) {
		// To store reverse of original map, each key will have 0
		// to multiple values
		Map<String, List<String>> mngrEmpMap = new HashMap<String, List<String>>();

		// To fill mngrEmpMap, iterate through the given map
		for (Map.Entry<String, String> entry : dataSet.entrySet()) {
			String emp = entry.getKey();
			String mngr = entry.getValue();
			if (!emp.equals(mngr)) // excluding emp-emp entry
			{
				// Get the previous list of direct reports under
				// current 'mgr' and add the current 'emp' to the list
				List<String> directReportList = mngrEmpMap.get(mngr);

				// If 'emp' is the first employee under 'mgr'
				if (directReportList == null) {
					directReportList = new ArrayList<String>();
					// add a new entry for the mngr with empty directReportList
					mngrEmpMap.put(mngr, directReportList);
				}
				directReportList.add(emp);
			}
		}

		// Now use manager-Emp map built above to populate result
		// with use of populateResultUtil()

		// note- we are iterating over original emp-manager map and
		// will use mngr-emp map in helper to get the count
		for (String mngr : dataSet.keySet())
			populateResultUtil(mngr, mngrEmpMap);
	}

	// This is a recursive function to fill count for 'mgr' using
	// mngrEmpMap. This function uses memoization to avoid re-
	// computations of subproblems.
	private static int populateResultUtil(String mngr, Map<String, List<String>> mngrEmpMap) {
		int count = 0;

		// means employee is not a manager of any other employee
		if (!mngrEmpMap.containsKey(mngr)) {
			result.put(mngr, 0);
			return 0;
		}

		// this employee count has already been done by this
		// method, so avoid re-computation
		else if (result.containsKey(mngr))
			count = result.get(mngr);

		else {
			List<String> directReportEmpList = mngrEmpMap.get(mngr);
			count = directReportEmpList.size();
			for (String directReportEmp : directReportEmpList)
				count += populateResultUtil(directReportEmp, mngrEmpMap);

			result.put(mngr, count);
		}
		return count;
	}
}
