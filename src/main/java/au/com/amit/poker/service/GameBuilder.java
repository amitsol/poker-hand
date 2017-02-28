package au.com.amit.poker.service;

import java.util.HashSet;
import java.util.Set;

import au.com.amit.poker.domain.Card;
import au.com.amit.poker.domain.Game;
import au.com.amit.poker.domain.Player;

public class GameBuilder {
	
	public Game build(String input, Player player1, Player player2) {
		if (input == null || input.length() == 0) {
			throw new IllegalArgumentException("Input is invalid");
		}

		String[] values = input.split(" ");

		if (values.length < 10) {
			throw new IllegalArgumentException("10 cards should be specified in the input");
		}

		Set<Card> firstPlayerCards = new HashSet<>(5);
		Set<Card> secondPlayerCards = new HashSet<>(5);

		for (int i = 0; i < values.length; i++) {
			String value = values[i];

			Card card = new Card(value);

			if (i <= 4) {
				firstPlayerCards.add(card);
			} else {
				secondPlayerCards.add(card);
			}
		}
		
		Game game = new Game();
		player1.setCards(firstPlayerCards);
		game.addPlayer(player1);
		player2.setCards(secondPlayerCards);
		game.addPlayer(player2);
		return game;
	}

}
