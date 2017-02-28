package au.com.amit.poker.rule;

import org.junit.Assert;
import org.junit.Test;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;

public class RuleTwoPairTest {
	
	@Test
	public void testRuleFlush() {
		Player player = new Player();
		
		Card c2 = new Card("6S"); 
		player.addCard(c2);
		Card c3 = new Card("5D"); 
		player.addCard(c3);
		Card c4 = new Card("4S"); 
		player.addCard(c4);
		Card c5 = new Card("6D");
		player.addCard(c5);
		Card c1 = new Card("4S"); 
		player.addCard(c1);
		
		Rule rule = new RuleTwoPair();
		Integer calculateRank = rule.calculateRank(player);
		Assert.assertEquals(calculateRank , Integer.valueOf(20));
		
	}

}
