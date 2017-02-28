package au.com.amit.poker.rule;

import org.junit.Assert;
import org.junit.Test;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;

public class RuleFlushTest {
	
	@Test
	public void testRuleFlush() {
		Player player = new Player();
		
		Card c1 = new Card("2C"); 
		player.addCard(c1);
		Card c2 = new Card("3C"); 
		player.addCard(c2);
		Card c3 = new Card("4C"); 
		player.addCard(c3);
		Card c4 = new Card("7C"); 
		player.addCard(c4);
		Card c5 = new Card("9C");
		player.addCard(c5);
		
		RuleFlush flush = new RuleFlush();
		Integer calculateRank = flush.calculateRank(player);
		Assert.assertTrue(calculateRank == 25);
		
	}

}
