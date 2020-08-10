
public class StringContains {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String useCase="ECOM_TXN_NEW";
		String validateAndRemoveUseCases="ECOM_TXN";
		
		System.out.println(validateAndRemoveUseCases.contains(useCase));
		
		System.out.println(useCase.contains(validateAndRemoveUseCases));
	}

}
