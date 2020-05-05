package leetcodeproblem.may2020;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
	public int firstBadVersion(int n) {
		return firstBadVersion(0, n);
	}

	public int firstBadVersion(int S, int E) {
		if (S == E) {
			return S;
		}
		int mid = S + (E - S) / 2;
		if (isBadVersion(mid)) {
			return firstBadVersion(S, mid);
		} else {
			return firstBadVersion(mid + 1, E);
		}
	}
}