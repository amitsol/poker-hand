package au.com.amit.poker.rule;

import au.com.amit.poker.domain.Player;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class RuleThreeOfKind extends Rule {

	private static final int RANK_HIGH_CARD = 4;

	@Override
	public int getPriority() {
		return RANK_HIGH_CARD;
	}

	public Integer calculateRank(Player player) {
		return calculateRankForSameKindOfCards(player.getCards(), 3);
	}
}
