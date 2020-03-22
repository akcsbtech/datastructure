package Immutability;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber {
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;

	public PhoneNumber(int areaCode, int prefix, int lineNumber) throws IllegalAccessException {
		// super();
		rangeCheck(areaCode, 999, "area code");
		rangeCheck(prefix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "line number");
		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}

	private static void rangeCheck(int arg, int max, String name) throws IllegalAccessException {
		if (arg < 0 || arg > max) {
			throw new IllegalAccessException(name + ":" + arg);
		}
	}

	/*
	 * @Override public boolean equals(Object o) {
	 * System.out.println("Equals method call {}" + o.toString()); if (o == this) {
	 * return true; } if (!(o instanceof PhoneNumber)) { return false; } PhoneNumber
	 * p = (PhoneNumber) o;
	 * 
	 * return p.lineNumber == lineNumber && p.areaCode == areaCode && p.prefix ==
	 * prefix; }
	 */

	@Override
	public int hashCode() {

		int result = 17;
		result = result * 31 + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		System.out.println("HashCode method call {}" + result);
		return result;
	}

	@Override
	public String toString() {
		return "PhoneNumber [areaCode=" + areaCode + ", prefix=" + prefix + ", lineNumber=" + lineNumber + "]";
	}
	
}
