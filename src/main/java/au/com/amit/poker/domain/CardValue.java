package au.com.amit.poker.domain;

import java.util.Optional;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public enum CardValue {

	ACE(14, "A"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8,
			"8"), NINE(9, "9"), TEN(10, "T"), JACK(11, "J"), QUEEN(12, "Q"), KING(13, "K");

	int value = -1;
	String stringRepresentation;

	CardValue(int i, String strRepresent) {
		this.value = i;
		this.stringRepresentation = strRepresent;
	}

	int getValue() {
		return value;
	}

	public static Optional<CardValue> toCardValue(String value) {
		for (CardValue cardValue : CardValue.values()) {
			if (cardValue.getStringRepresentation().equals(value)) {
				return Optional.of(cardValue);
			}
		}
		return Optional.empty();
	}

	public String getStringRepresentation() {
		return stringRepresentation;
	}
}
