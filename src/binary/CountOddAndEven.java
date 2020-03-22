package binary;

public class CountOddAndEven {

	int noOfOns = 0;
	int noOfZero = 0;

	public static void main(String[] arg) {
		CountOddAndEven countOddAndEven = new CountOddAndEven();
		
		String bin=Integer.toBinaryString(17);
		int num = countOddAndEven.findMaxInt(bin);
		int count = 0;
		for (int i = 0; i <= num; i++) {
			if (countOddAndEven.findOddOnsAndZero(i) == 1) {
				++count;
			}
		}
		System.out.println("Nos of String : " + count);
	}

	public int findOddOnsAndZero(int num) {
		int t=num;
		int div = 0;
		int zero = 0;
		int ons = 0;
		// System.out.println("num |" + num + " |");
		if (num == 0 || num==1) {
			return 1;
		}
		while (num > 0) {
			div = num % 2;
			num = num / 2;
			if (div == 0) {
				++zero;
			} else {
				++ons;
			}
		}
		if (noOfOns >= ons && noOfZero >= zero) {
			if ((zero % 2 == 1 && ons % 2 == 1) || (ons % 2 == 1) || (zero % 2 == 1 )) {
				System.out.println("Num :"+t+"Zero |  " + zero + " | ons |" + ons);
				return 1;
			}
		}
		return 0;
	}


	public int findMaxInt(String number) {
		int ons = NoOfOnes(number);
		String maxNumber = "";

		for (int i = 0; i < number.length(); i++) {
			if (i < ons) {
				maxNumber = maxNumber + "1";
			} else {
				maxNumber = maxNumber + "0";
			}
		}
		noOfOns = ons;
		noOfZero = number.length() - noOfOns;
		return findBinaryValue(maxNumber);
	}

	public int NoOfOnes(String number) {
		int ons = 0;
		byte[] b = number.getBytes();

		for (int i = 0; i < b.length; i++) {
			if (b[i] == 49) {
				++ons;
			}
		}
		return ons;
	}

	public int findBinaryValue(String binary) {
		int num = 0;
		int count = 0;
		byte[] number = binary.getBytes();
		for (int i = number.length - 1; i >= 0; --i) {
			num = (int) (num + Math.pow((double) 2, (double) count) * (number[i] - 48));
			++count;
		}
		return num;
	}

}
