package au.com.amit.poker.rule;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;
import au.com.amit.poker.domain.Suit;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class RuleRoyalFlush extends Rule {

	private static final int RANK_HIGH_CARD = 10;

	@Override
	public int getPriority() {
		return RANK_HIGH_CARD;
	}

	public Integer calculateRank(Player player) {
		Set<Card> cards = player.getCards();
		
		Map<Suit, Long> kinds = cards.stream()
				.collect(Collectors.groupingBy(Card::getSuit, Collectors.counting()));
		
		Set<Integer> collect = cards.stream()
			.map(i -> i.getValue())
			.collect(Collectors.toSet());
		
		if(kinds.values().contains(5L)) {
			if(collect.contains(10) && 
					collect.contains(11) && 
						collect.contains(12) &&
							collect.contains(13) &&
								collect.contains(14)) {
				return 60;
			}
		}
		
		return -1;
	}
}
