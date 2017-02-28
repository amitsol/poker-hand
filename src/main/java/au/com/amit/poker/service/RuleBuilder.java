package au.com.amit.poker.service;

import java.util.ArrayList;
import java.util.List;

import au.com.amit.poker.rule.Rule;
import au.com.amit.poker.rule.RuleFlush;
import au.com.amit.poker.rule.RuleFourOfKind;
import au.com.amit.poker.rule.RuleFullHouse;
import au.com.amit.poker.rule.RuleHighCard;
import au.com.amit.poker.rule.RulePair;
import au.com.amit.poker.rule.RuleRoyalFlush;
import au.com.amit.poker.rule.RuleStraight;
import au.com.amit.poker.rule.RuleStraightFlush;
import au.com.amit.poker.rule.RuleThreeOfKind;
import au.com.amit.poker.rule.RuleTwoPair;

public class RuleBuilder {
	
	public List<Rule> buildRules() {
	    List<Rule> rules = new ArrayList<>();

    	Rule ruleFlush = new RuleFlush();
    	rules.add(ruleFlush);
    	Rule ruleFourOfKind = new RuleFourOfKind();
    	rules.add(ruleFourOfKind);
    	Rule ruleFullHouse = new RuleFullHouse();
    	rules.add(ruleFullHouse);
    	Rule rulePair = new RulePair();
    	rules.add(rulePair);
    	Rule ruleRoyalFlush = new RuleRoyalFlush();
    	rules.add(ruleRoyalFlush);
    	Rule ruleStraight = new RuleStraight();
    	rules.add(ruleStraight);
    	Rule ruleStraightFlush = new RuleStraightFlush();
    	rules.add(ruleStraightFlush);
    	Rule ruleThreeOfKind = new RuleThreeOfKind();
    	rules.add(ruleThreeOfKind);
    	Rule ruleTwoPair = new RuleTwoPair();
    	rules.add(ruleTwoPair);
    	Rule ruleHighCard = new RuleHighCard();
    	rules.add(ruleHighCard);
    	
    	rules.sort((Rule r1, Rule r2) -> r2.getPriority() - r1.getPriority());
    	
    	return rules;

	}

}
