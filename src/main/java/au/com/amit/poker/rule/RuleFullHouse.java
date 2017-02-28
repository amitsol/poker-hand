package au.com.amit.poker.rule;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class RuleFullHouse extends Rule {

	private static final int RANK_HIGH_CARD = 7;

	@Override
	public int getPriority() {
		return RANK_HIGH_CARD;
	}

	public Integer calculateRank(Player player) {
		Set<Card> cards = player.getCards();

		Map<Integer, Long> kinds = cards.stream()
				.collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));
		
		if (kinds.values().contains(3L) && kinds.values().contains(2L)) {
			return cards.stream()
					.mapToInt(i -> i.getValue())
					.sum();
		}
		
		return -1;
	}
}
