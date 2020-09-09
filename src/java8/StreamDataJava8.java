/**
 * 
 */
package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.util.Pair;



/**
 * @author b0218163
 *
 */
public class StreamDataJava8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Map<OnboardingState, Map<String, String>> onboardingStepConfigMap=new HashMap<>();
		  
		  Map<String, String> internalmap=new HashMap<>();
		  
		  internalmap.put("mandatory", "true");
		  internalmap.put("lastInput", "true");
		  internalmap.put("finalStep", "false");
		  
		  onboardingStepConfigMap.put(OnboardingState.INITIATE, internalmap);
		  
		  Map<OnboardingState, OnboardingStepConfig> onboardingStepConfigMapped;
		 
		  onboardingStepConfigMapped = onboardingStepConfigMap.entrySet().stream()
	    			.map(entry -> Pair.of(entry.getKey(), MAPPER.convertValue(entry.getValue(), OnboardingStepConfig.class))).
	    			
	    			
	    			
	    			
		onboardingStepConfigMapped = onboardingStepConfigMap.entrySet().stream()
    			.map(entry -> Pair.of(entry.getKey(), MAPPER.convertValue(entry.getValue(), OnboardingStepConfig.class)))
    			.collect(Collectors.toMap(entry.getKey(), entry.getValue()));

	}

}
