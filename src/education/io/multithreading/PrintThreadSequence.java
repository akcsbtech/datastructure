package education.io.multithreading;

public class PrintThreadSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintNumberSeries zeo = new PrintNumberSeries(15);
		Thread t1 = new PrintNumberSeriesThread(zeo, "zero");
		Thread t2 = new PrintNumberSeriesThread(zeo, "even");
		Thread t3 = new PrintNumberSeriesThread(zeo, "odd");

		t2.start();
		t1.start();
		t3.start();

	}

}
