package org.intervw.hexagon.service;

import java.util.List;

import org.intervw.hexagon.model.CreditCard;

public interface CreditCardService {

	public List<CreditCard> generateCreditCards(String cardType,
			int nbrOfCards) throws Exception;
}
