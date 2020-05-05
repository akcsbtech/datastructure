package education.io.multithreading;

public class TokenBucketFilter {

	private int MAX_TOKENS;
	// variable to note down the latest token request.
	private long lastRequestTime = System.currentTimeMillis();
	long possibleTokens = 0;

	public TokenBucketFilter(int maxTokens) {
		MAX_TOKENS = maxTokens;
	}

	synchronized void getToken() throws InterruptedException {

	}
}