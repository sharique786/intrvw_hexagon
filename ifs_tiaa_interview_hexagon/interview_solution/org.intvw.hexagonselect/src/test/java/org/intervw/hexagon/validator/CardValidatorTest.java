package org.intervw.hexagon.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardValidatorTest {

	CardValidator validator = new CardValidator();
	
	@Test
	public void shouldReturnTrueWhenPassedCardType(){
		assertTrue(validator.isCardType("VISA"));
	}
	
	@Test
	public void shouldReturnFalseWhenPassedCardType(){
		assertFalse(validator.isCardType("ABCD"));
	}
	
	@Test
	public void shouldReturnFalseWhenPassedCardNumber(){
		assertFalse(validator.validateCardNumber("22142354234534654623"));
	}
	
	@Test
	public void shouldReturnTrueWhenPassedCardNumber(){
		assertTrue(validator.validateCardNumber("4415036350853213"));
	}
}
