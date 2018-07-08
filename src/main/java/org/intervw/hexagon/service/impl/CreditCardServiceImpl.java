package org.intervw.hexagon.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.intervw.hexagon.model.CreditCard;
import org.intervw.hexagon.service.CreditCardService;
import org.intervw.hexagon.validator.CardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("creditCardService")
public class CreditCardServiceImpl implements CreditCardService{
	
	public enum CardType
	{
	    VISA {
	        @Override
	        public String generateNumber()
	        {
	        	AtomicLong numberGenerator = new AtomicLong(4000000000000000L);	        	
	            StringBuffer stringBuffer = new StringBuffer();	           
	            stringBuffer.append(numberGenerator.getAndIncrement() + Long.valueOf(generateRandomNumber()));	                
	            return stringBuffer.toString();
	        }
	    },
	    MASTER {
	        @Override
	        public String generateNumber()
	        {
	        	AtomicLong numberGenerator = new AtomicLong(5000000000000000L);	        	
	            StringBuffer stringBuffer = new StringBuffer();	           
	            stringBuffer.append(numberGenerator.getAndIncrement() + Long.valueOf(generateRandomNumber()));	                
	            return stringBuffer.toString();
	        }
	    },
	    AMEX {
	        @Override
	        public String generateNumber()
	        {
	        	AtomicLong numberGenerator = new AtomicLong(3700000000000000L);	        	
	            StringBuffer stringBuffer = new StringBuffer();	           
	            stringBuffer.append(numberGenerator.getAndIncrement() + Long.valueOf(generateRandomNumber()));	                
	            return stringBuffer.toString();
	        }
	    },
	    DISCOVER {
	        @Override
	        public String generateNumber()
	        {
	        	AtomicLong numberGenerator = new AtomicLong(6000000000000000L);	        	
	            StringBuffer stringBuffer = new StringBuffer();	           
	            stringBuffer.append(numberGenerator.getAndIncrement() + Long.valueOf(generateRandomNumber()));	                
	            return stringBuffer.toString();
	        }
	    };
	    
		public String generateRandomNumber()
        {
        	Random rnd = new Random();
            int counter=0;
            StringBuffer stringBuffer = new StringBuffer();
            while(counter<15){
                int generate = rnd.nextInt(9); 
                stringBuffer.append(generate);
                counter++;
            }
            System.out.println("Random nbr:" + stringBuffer.toString());
            return stringBuffer.toString();
        }

	    public abstract String generateNumber();
	}
	
	@Autowired
	private CardValidator cardValidator;

	@Override
	public List<CreditCard> generateCreditCards(String cardType, int nbrOfCards) throws Exception {
		if(nbrOfCards <= 0 || (null == cardType && " ".equals(cardType))){
			throw new IllegalArgumentException("One of the i/p is incorrect.");
		}
		List<CreditCard> creditCardList = new ArrayList<>(); 		
		
		long cdId = 1000000L; 
		int cardNbr = 1;
		
		for(int i= 0; i< nbrOfCards; i++){
			String generatedCardNbr = getCreditCardNumber(cardType);
			if(null != generatedCardNbr){
				CreditCard cc = new CreditCard();
				cc.setId(cdId++);
				cc.setCcType(cardType.toUpperCase());
				cc.setCcNumber(generatedCardNbr);
				cc.setNoOfCards(cardNbr++);
				cc.setExpiryDate(getExpiryDate());
				creditCardList.add(cc);
			}			
		}
		return creditCardList;
	}
	
	private String getExpiryDate(){
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    return formatter.format(date); 		
	}
	
	public String getCreditCardNumber(String cardType){		
		String generatedCardNbr =  CardType.valueOf(cardType.toUpperCase()).generateNumber();
		if(cardValidator.validateCardNumber(generatedCardNbr)){
			return generatedCardNbr;
		}else{
			return null;
		}		
	}

}
