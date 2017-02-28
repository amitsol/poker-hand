/**
 * Created by Amit Solankurkar on 26/2/17.
 */
package au.com.amit.poker.domain;

import java.util.Objects;
import java.util.Optional;

public class Card {

	private Suit suit;

	private CardValue value;

	public Card(String cardString) {
		if (cardString.length() == 2) {
			String v = cardString.substring(0, 1);
			String s = cardString.substring(1, 2);

			Optional<Suit> optSuit = Suit.toSuit(s);
			Optional<CardValue> optCardValue = CardValue.toCardValue(v);
			this.suit = optSuit.get();
			this.value = optCardValue.get();
		}
	}

	public Card(Suit suit, CardValue value) {
		this.suit = suit;
		this.value = value;
	}

	public int getValue() {
		return value.getValue();
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Card other = (Card) obj;
		return Objects.equals(this.suit, other.getSuit()) && Objects.equals(this.value, other.getValue());
	}

}
