package org.intervw.hexagon.validator;

import org.springframework.stereotype.Service;

@Service
public class CardValidator {

	public boolean validateCardNumber(String ccNumber){
		boolean isCardNumberCorrect = false;
		
		if(ccNumber.length()==16){
		    char[] c = ccNumber
		    		.toCharArray();
		    int[] cint = new int[16];
		    for(int i=0;i<16;i++){
		        if(i%2==1){
		            cint[i] = Integer.parseInt(String.valueOf(c[i]))*2;
		            if(cint[i] >9)
		                cint[i]=1+cint[i]%10;
		        }
		        else
		            cint[i] = Integer.parseInt(String.valueOf(c[i]));
		    }
		    int sum=0;
		    for(int i=0;i<16;i++){
		        sum+=cint[i];
		    }
		    if(sum%10==0){
		    	isCardNumberCorrect = true;
		    }
		}
		
		return isCardNumberCorrect;
	}
	
	public boolean isCardType(String cardType)
	{		
	    
	    if("VISA".equalsIgnoreCase(cardType)){
	        return true;
	    }else if("MASTERCARD".equalsIgnoreCase(cardType)){
	    	return true;
	    }else if("DISCOVER".equalsIgnoreCase(cardType)){
	    	return true;
	    }else if("AMEX".equalsIgnoreCase(cardType)){
	    	return true;
	    }else{
	        return false;
	    }	    
	}
}
