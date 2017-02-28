package au.com.amit.poker.rule;

import org.junit.Assert;
import org.junit.Test;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Player;

public class RuleFourOfKindTest {
	
	@Test
	public void testRuleFlush() {
		Player player = new Player();
		
		Card c2 = new Card("2H"); 
		player.addCard(c2);
		Card c3 = new Card("2S"); 
		player.addCard(c3);
		Card c4 = new Card("2D"); 
		player.addCard(c4);
		Card c5 = new Card("9C");
		player.addCard(c5);
		Card c1 = new Card("2C"); 
		player.addCard(c1);
		
		Rule rule = new RuleFourOfKind();
		Integer calculateRank = rule.calculateRank(player);
		Assert.assertEquals(calculateRank , Integer.valueOf(8));
		
	}

}
