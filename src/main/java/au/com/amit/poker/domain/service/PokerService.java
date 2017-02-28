package au.com.amit.poker.domain.service;

import java.io.BufferedReader;
import java.util.List;

import au.com.amit.poker.domain.Game;
import au.com.amit.poker.domain.Player;
import au.com.amit.poker.rule.Rule;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class PokerService {

	private List<Rule> rules;
	
	private GameBuilder builder = new GameBuilder();
	private InputReader fileReader = new InputReader();
	private RuleBuilder ruleBuilder = new RuleBuilder();

	public PokerService() {
		this.rules = ruleBuilder.buildRules();
	}

	public Game calculateRanking(BufferedReader reader) {
		List<String> fileContents = fileReader.getFileContents(reader);
		return calculateRanking(fileContents);
	}

	public Game calculateRanking(String filePath) {
		List<String> fileContents = fileReader.getFileContents(filePath);
		return calculateRanking(fileContents);
	}

	private Game calculateRanking(List<String> fileContents) {
		Player player2 = new Player();
		Player player1 = new Player();
		
		Integer player1Score = 0;
		Integer player2Score = 0;
		
		Game game = null;
		for (String string : fileContents) {
			
			int player1Rank = 0;
			int player2Rank = 0;
			
			game = builder.build(string, player1, player2);
			System.out.println(string);
			
			player1Rank = getRankForAPlayer(game.getPlayers().get(0));
			player2Rank = getRankForAPlayer(game.getPlayers().get(1));
			
			if(player1Rank == player2Rank) {
				if(player1.getHighestCard() == player2.getHighestCard()) {
					player1Score++;
					player2Score++;
				} else if(player1.getHighestCard() > player2.getHighestCard()) {
					player1Score++;
				} else {
					player2Score++;
				}
			} else if(player1Rank > player2Rank) {
				player1Score++;
			} else {
				player2Score++;
			}
		}
		
		System.out.println(player1Score);
		System.out.println(player2Score);
		
		return null;
	}
	
	private Integer getRankForAPlayer(Player player) {
		int rank = 0;
		for (Rule rule : rules) {
			Integer calculateRank = rule.calculateRank(player);
			if(calculateRank > 0) {
				rank = rank + calculateRank;
				break;
			}
		}
		
		System.out.println(rank);
		return rank;
	}


}