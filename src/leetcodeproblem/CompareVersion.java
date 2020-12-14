package leetcodeproblem;

public class CompareVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("0.1", "1.1"));

	}

	public static int compareVersion(String version1, String version2) {

		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");

		int len = ver1.length > ver2.length ? ver2.length : ver1.length;
		System.out.println(len + "   :" + ver1.length);

		for (int i = 0; i < len; i++) {
			int x1 = Integer.parseInt(ver1[i]);
			int x2 = Integer.parseInt(ver2[i]);
			System.out.println(" x1 :" + x1 + " x2:" + x2);
			if (x1 == x2)
				continue;
			else if (x1 > x2)
				return 1;
			else
				return -1;

		}
		return 0;

	}

	public int compareVersionWithOutSplit(String a, String b) {
		for (int i = 0, j = 0, m, n; i < a.length() || j < b.length(); i++, j++) {
			m = n = 0;
			while (i < a.length() && a.charAt(i) != '.')
				m = m * 10 + a.charAt(i++) - '0';
			while (j < b.length() && b.charAt(j) != '.')
				n = n * 10 + b.charAt(j++) - '0';
			if (m > n)
				return 1;
			if (m < n)
				return -1;
		}
		return 0;
	}
}
