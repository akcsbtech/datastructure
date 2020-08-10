package systemdesign.searchfile.snakeladder;

public class SixFaceDice implements Dice {
	private static SixFaceDice s;

	public int roll() {
		// generate random number between 1 to 6
		return (int) System.currentTimeMillis() % 6 + 1;
	}

	private  SixFaceDice() {
	}

	public static  SixFaceDice getSixFaceDice() {
    if (s == null) { 
    	s=new SixFaceDice();
    	return s;
    			}
    else {
     return s;
    }
  }
}