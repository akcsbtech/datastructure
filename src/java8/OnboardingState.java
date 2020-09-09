package java8;
@ToString
public enum OnboardingState implements ProcessorProvider {

	INITIATE("InitialFlowProcessor"),
	PERSONAL_DETAILS("PersonalDetailsProcessor"),
	SHOP_DETAILS("ShopDetailsProcessor"),
	SETTLEMENT_DETAILS("BankDetailsProcessor"),
	AADHAAR("AadhaarProcessor"),
	AADHAAR_NAME_MATCH("AadhaarNameMatchProcessor"),
	PAN("PanProcessor"),
	PAN_NAME_MATCH("PanNameMatchProcessor"),
	SETTLEMENT_ACC_NAME_MATCH("SettlementAccNameMatchProcessor"),
	FINAL_ONBORDING("OnbordingDetailsProcessor"),
	UPDATE_DETAILS("UpdateDetailsProcessor"),
	BUSINESS_DETAILS("BusinessDetailsProcessor"),
	MPIN_DETAILS("MpinDetailsProcessor"),
	ADDITIONAL_PERSONAL_DETAILS("AdditionalPersonalDetailsProcessor"),
	ONBOARDING_CONSENT("OnboardingConsentProcessor");
	
	private final String processor;
	OnboardingState(String processor){
		this.processor = processor;
	}
	
	@Override
	public String getProcessor() {
		return this.processor;
	}

}