package au.com.amit.poker.rule;

import java.util.Set;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class RulePair extends Rule {

	private static final int RANK_HIGH_CARD = 2;

	@Override
	public Integer calculateRank(Player player) {
		Set<Card> cards = player.getCards();
		return calculateRankForSameKindOfCards(cards, 2);
	}

	@Override
	public int getPriority() {
		return RANK_HIGH_CARD;
	}

}
