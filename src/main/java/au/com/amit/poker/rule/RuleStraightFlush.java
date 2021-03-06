package au.com.amit.poker.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;
import au.com.amit.poker.domain.Suit;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class RuleStraightFlush extends Rule {

	private static final int RANK_HIGH_CARD = 9;

	@Override
	public int getPriority() {
		return RANK_HIGH_CARD;
	}

	public Integer calculateRank(Player player) {
		Set<Card> setcards = player.getCards();
		List<Card> cards = new ArrayList<>(setcards);
		cards.sort((Card c1, Card c2) -> c1.getValue() - c2.getValue());
		
		int prevValue = 0;
		Suit prevSuit = null;
		int retVal = 0;
		
		boolean isSequential = true;
		
		for (Card card : cards) {
			retVal = retVal + card.getValue();
			if(prevValue == 0) {
				prevValue = card.getValue();
				prevSuit = card.getSuit();
			} else {
				if(card.getValue() != prevValue + 1 || prevSuit != card.getSuit() ) {
					isSequential = false;
					break;
				} else {
					prevValue = card.getValue();
					prevSuit = card.getSuit();
				}
			}
		}
		
		if(isSequential) {
			return retVal;
		} else {
			return -1;
		}
		

	}
}
