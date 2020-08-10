package leetcodeproblem;

public class NestedInteger {

	int value;
	NestedInteger ns;
	
	public NestedInteger() {}
	
	public NestedInteger(int value) {
		this.value=value;
	}
	
	public void add(NestedInteger ns) {
		this.value=ns.value;
		this.ns=ns;
	}
}
