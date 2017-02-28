package au.com.amit.poker.domain;

import java.util.Optional;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public enum Suit {

	DIAMOND, HEART, SPADE, CLUB;

	public static Optional<Suit> toSuit(String s) {
		switch (s) {
		case "D":
			return Optional.of(DIAMOND);
		case "H":
			return Optional.of(HEART);
		case "S":
			return Optional.of(SPADE);
		case "C":
			return Optional.of(CLUB);
		default:
			return Optional.empty();
		}
	}

}
