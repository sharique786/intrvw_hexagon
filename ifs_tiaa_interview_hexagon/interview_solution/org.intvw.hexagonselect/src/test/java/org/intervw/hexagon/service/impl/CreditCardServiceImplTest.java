package org.intervw.hexagon.service.impl;

import org.junit.Test;

public class CreditCardServiceImplTest {

	CreditCardServiceImpl cardService = new CreditCardServiceImpl();
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenNullCardTypePassed(){
		cardService.generateCreditCards(null, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenZeroCardNbrPassed(){
		cardService.generateCreditCards("VISA", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenWrongCardTypePassed(){
		cardService.generateCreditCards("ABC", 1);		
	}
}
