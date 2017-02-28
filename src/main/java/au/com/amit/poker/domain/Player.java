package au.com.amit.poker.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class Player {

	private Set<Card> cards = new HashSet<>();
	private Integer highestCard = CardValue.TWO.getValue(); 
	
	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	public Integer getHighestCard() {
		return highestCard;
	}

	public void setHighestCard(Integer integer) {
		this.highestCard = integer;
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
}
