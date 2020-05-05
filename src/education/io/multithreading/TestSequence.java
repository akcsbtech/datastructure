package education.io.multithreading;

public class TestSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunNThreadSequence rts=new RunNThreadSequence(3);
		new Thread(rts.).start();
	}

}
