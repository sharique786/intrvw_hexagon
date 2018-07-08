package org.intervw.hexagon.controller;

import org.intervw.hexagon.validator.CardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CCValidate")
public class CreditCardValidator {

	@Autowired
	private CardValidator cardValidator;
	
	@GetMapping(value = "/{cardType}/{cardNumber}")
	@ResponseBody
	public String generateCreditCardDetails(@PathVariable(name="cardType", required=true) String cardType,
			@PathVariable(name="cardNumber", required=true) String cardNumber) throws Exception{
		
		String invalidCardMsg = "Card is Invalid";
		if(cardValidator.isCardType(cardType)){
			if(cardValidator.validateCardNumber(cardNumber)){
				return "Card is Valid";
			}
		}else return invalidCardMsg;
		
		return invalidCardMsg;
	}
}
