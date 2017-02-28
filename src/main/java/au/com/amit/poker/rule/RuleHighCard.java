package au.com.amit.poker.rule;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class RuleHighCard extends Rule {

	private static final int RANK_HIGH_CARD = 1;

	@Override
	public int getPriority() {
		return RANK_HIGH_CARD;
	}

	public Integer calculateRank(Player player) {
		Set<Card> cards = player.getCards();
		
		Optional<Integer> max = cards.stream()
			.map(i -> i.getValue())
			.max(Comparator.naturalOrder());
		
		player.setHighestCard(max.get());
		return max.get();
	}
}
