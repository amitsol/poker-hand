package au.com.amit.poker.rule;

import org.junit.Assert;
import org.junit.Test;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;

public class RuleStraightTest {
	
	@Test
	public void testRuleFlush() {
		Player player = new Player();
		
		Card c2 = new Card("6S"); 
		player.addCard(c2);
		Card c3 = new Card("3S"); 
		player.addCard(c3);
		Card c4 = new Card("4S"); 
		player.addCard(c4);
		Card c5 = new Card("7S");
		player.addCard(c5);
		Card c1 = new Card("5S"); 
		player.addCard(c1);
		
		Rule rule = new RuleStraightFlush();
		Integer calculateRank = rule.calculateRank(player);
		Assert.assertEquals(calculateRank , Integer.valueOf(25));
		
	}

	@Test
	public void testRuleFlush_Negative() {
		Player player = new Player();
		
		Card c2 = new Card("6S"); 
		player.addCard(c2);
		Card c3 = new Card("3S"); 
		player.addCard(c3);
		Card c4 = new Card("4D"); 
		player.addCard(c4);
		Card c5 = new Card("7S");
		player.addCard(c5);
		Card c1 = new Card("5S"); 
		player.addCard(c1);
		
		Rule rule = new RuleStraightFlush();
		Integer calculateRank = rule.calculateRank(player);
		Assert.assertEquals(calculateRank , Integer.valueOf(-1));
	}
}
