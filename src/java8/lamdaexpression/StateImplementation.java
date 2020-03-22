package java8.lamdaexpression;

public class StateImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StateOwner stateOwner = new StateOwner();

		stateOwner.addStateListener(new StateChangeListener() {

			public void onStateChange(State oldState, State newState) {
				System.out.println("OnStateChange method call");
			}
		});

		stateOwner.addStateListener((oldState, newState) -> System.out.println("State changed"));
	}

}
