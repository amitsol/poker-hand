package au.com.amit.poker.rule;

import org.junit.Assert;
import org.junit.Test;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;

public class RuleRoyalFlushTest {
	
	@Test
	public void testRuleFlush() {
		Player player = new Player();
		
		Card c2 = new Card("TH"); 
		player.addCard(c2);
		Card c3 = new Card("JH"); 
		player.addCard(c3);
		Card c4 = new Card("QH"); 
		player.addCard(c4);
		Card c5 = new Card("KH");
		player.addCard(c5);
		Card c1 = new Card("AH"); 
		player.addCard(c1);
		
		Rule rule = new RuleRoyalFlush();
		Integer calculateRank = rule.calculateRank(player);
		Assert.assertEquals(calculateRank , Integer.valueOf(60));
		
	}

}
