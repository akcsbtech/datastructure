package multithreading;

public class PrintNumberSeriesThread extends Thread {

	PrintNumberSeries zeo;
	String method;

	public PrintNumberSeriesThread(PrintNumberSeries zeo, String method) {
		this.zeo = zeo;
		this.method = method;
	}

	public void run() {
		if ("zero".equals(method)) {
			try {
				zeo.printZero();
			} catch (Exception ex) {

			}
		} else if ("even".equals(method)) {
			try {
				zeo.printEven();
			} catch (Exception ex) {

			}
		} else if ("odd".equals(method)) {
			try {
				zeo.printOdd();
			} catch (Exception ex) {

			}
		}
	}

}
