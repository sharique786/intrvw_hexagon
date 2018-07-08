package org.intervw.hexagon.controller;

import java.util.List;

import org.intervw.hexagon.model.CreditCard;
import org.intervw.hexagon.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CCEngine")
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;
	
	@GetMapping(value = "/{cardType}/{noOfCards}")
	@ResponseBody
	public List<CreditCard> generateCreditCardDetails(@PathVariable(name="cardType", required=true) String cardType,
			@PathVariable(name="noOfCards", required=true) int noOfCards) throws IllegalArgumentException{
		
		return creditCardService.generateCreditCards(cardType.toUpperCase(), noOfCards);
	}
	
	@RequestMapping(value = "/error/")
    public String error() {
        return "Error handling";
    }
}
