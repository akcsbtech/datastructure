package leetcodeproblem;

import java.util.Arrays;

public class MettingRoom2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a= {0,5,15};
		int [] b= {30,10,20};
		
		System.out.println(mettingRoomRequire(a,b));
		
		int [] c= {7,2};
		int [] d= {10,7};
		
		System.out.println(mettingRoomRequire(c,d));
	}

	public static int mettingRoomRequire(int starts[],int ends[]) {
		int meetingRoom=0;
		
		Arrays.sort(starts);
		Arrays.sort(ends);
		int i=0;
		int j=0;
		
		while(i<starts.length && j<ends.length) {
			if(starts[i]<ends[j])
			{
				++meetingRoom;
				i++;
			}else {
				--meetingRoom;
				j++;
			}
		}
		return meetingRoom;
			
	}
}
