package au.com.amit.poker.rule;

import java.util.Set;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;
import au.com.amit.poker.domain.Suit;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class RuleFlush extends Rule {

	private static final int RANK_HIGH_CARD = 6;

	@Override
	public int getPriority() {
		return RANK_HIGH_CARD;
	}

	public Integer calculateRank(Player player) {
		int rank = 0;
		Set<Card> cards = player.getCards();
		Suit suit = null;
		
		for (Card card : cards) {
			rank = rank + card.getValue();
			if(suit == null) {
				suit = card.getSuit();
			} else {
				if(suit == card.getSuit()) {
					suit = card.getSuit();
				} else {
					return -1;
				}
			}
		}
		
		return rank;

	}
}
