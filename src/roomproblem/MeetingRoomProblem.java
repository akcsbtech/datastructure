package roomproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MeetingRoomProblem {

	Map<String, Integer> hmap = new HashMap<String, Integer>();

	public static void main(String[] arg) {
		MeetingRoomProblem meetingRoomProblem = new MeetingRoomProblem();
		int checkIn[] = { 1, 5, 8, 2 };
		int[] checkOut = { 4, 6, 9, 6 };
		int max=meetingRoomProblem.meetingRoomRequire(checkIn, checkOut);
		System.out.println("Max Room Require for complete meeting {}"+max);
	}

	public int meetingRoomRequire(int[] checkInTime, int[] checkOutTime) {
		// key is time and output is value
		for (int i = 0; i < checkInTime.length; i++) {
			checkCounter(checkInTime[i], checkOutTime[i]);
		}
		System.out.println(hmap);
		Set<String> keys = hmap.keySet();
		int max = 0;

		for (String key : keys) {
			Integer ii = hmap.get(key);
			if (max < ii) {
				max = ii;
			}
		}
		return max;
	}

	public int checkCounter(int checkIntime, int checkoutTIme) {
		if(hmap.size()==0) {
			hmap.put(checkIntime + "," + checkoutTIme, 1);
			return 0;
		}
		Set<String> keys = hmap.keySet();
		Map<String ,Integer> hmap_temp=new HashMap<String,Integer>();
		for (String key : keys) {
			Integer value = hmap.get(key);
			hmap_temp.put(key,value);
			if (value != null) {
				String[] arr = key.split(",");
				if (Integer.parseInt(arr[0]) <= checkIntime || Integer.parseInt(arr[0]) >= checkoutTIme) {
					hmap_temp.put(checkIntime + "," + checkoutTIme, ++value);
				} else {
					hmap_temp.put(checkIntime + "," + checkoutTIme, 1);
				}
			} else {
				hmap_temp.put(checkIntime + "," + checkoutTIme, 1);
			}
		}
		hmap=hmap_temp;
		return 0;
	}
}
