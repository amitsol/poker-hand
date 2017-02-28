package au.com.amit.poker.rule;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public abstract class Rule {

	public static final int DEFAULT_RANK = -1;

	public abstract Integer calculateRank(Player player);

	public abstract int getPriority();
	
	protected Integer calculateRankForSameKindOfCards(Set<Card> cards, int valueToCheck) {
		Map<Integer, Long> collect = cards.stream()
				.collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));

		if(collect.values().contains(Long.valueOf(valueToCheck))) {
			Set<Entry<Integer, Long>> entrySet = collect.entrySet();
			for (Entry<Integer, Long> entry : entrySet) {
				if(entry.getValue() == valueToCheck) {
					return entry.getKey();
				}
			}
		}
		
		return -1;
	}

}
