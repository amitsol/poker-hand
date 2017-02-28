package au.com.amit.poker.rule;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class RuleTwoPair extends Rule {

	private static final int RANK_HIGH_CARD = 3;

	@Override
	public int getPriority() {
		return RANK_HIGH_CARD;
	}

	public Integer calculateRank(Player player) {
		Set<Card> cards = player.getCards();
		Map<Integer, Long> collect = cards.stream()
				.collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));
		
		int frequency = Collections.frequency(collect.values(), 2L);

		int retVal = 0;
		if (frequency == 2) {
			Set<Entry<Integer, Long>> entrySet = collect.entrySet();
			for (Entry<Integer, Long> entry : entrySet) {
				if(entry.getValue() == 2) {
					retVal = retVal + entry.getKey();
				}
			}
			return retVal;
		}
		return -1;
	}
}
