package ian.projects.backend.domain;

import java.util.stream.IntStream;

/**
 * Represents the ISBN of a specific book edition.
 *
 * The ISBN is immutable and is normalized during creation.
 */
public final class ISBN {

	private final String value;
	private final String normalizedValue;
	private static final int ISBN_LENGTH_10 = 10;
	private static final int ISBN_LENGTH_13 = 13;

	public ISBN(String value) {
		this.value = value;

		validateNull();

		validateBlank();

		// Hyphens are accepted as input but are not part of the ISBN identity.
		this.normalizedValue = normalize();

		validateLength();

		if (normalizedValue.length() == ISBN_LENGTH_13) {
			validateISBN13();
			verifyCheckDigitForISBN13();
		}

		else {
			validateISBN10();
			verifyCheckDigitForISBN10();
		}

	}

	private void validateNull() {
		if (this.value == null) {
			throw new IllegalArgumentException("ISBN creation rejected. Value is null.");
		}
	}

	private void validateBlank() {
		if (this.value.isBlank()) {
			throw new IllegalArgumentException("ISBN creation rejected. Value is blank.");
		}
	}

	private String normalize() {
		String normalizedValue = value.replace("-", "");
		return normalizedValue;
	}

	private void validateLength() {
		if (normalizedValue.length() != ISBN_LENGTH_13 && normalizedValue.length() != ISBN_LENGTH_10) {
			throw new IllegalArgumentException(
					"ISBN creation rejected. ISBN must be either a valid ISBN-10 or ISBN-13.");
		}

	}

	private void validateISBN13() {
		if (!normalizedValue.matches("[0-9]+")) {
			throw new IllegalArgumentException("ISBN creation rejected. ISBN must contain digits.");
		}
	}

	private void validateISBN10() {
		if (!normalizedValue.matches("^[0-9]{9}[0-9xX]$")) {
			throw new IllegalArgumentException(
					"ISBN creation rejected. ISBN must contain 9 digits followed by a digit or X.");
		}
	}

	public String getValue() {
		return normalizedValue;
	}

	private void verifyCheckDigitForISBN13() {

		int informedDigit = getInformedDigitFromISBN13();
		int[] twelveDigits = getFirstTwelveDigits();
		int weightedSum = calculateISBN13WeightedSum(twelveDigits);
		int checkDigit = calculateCheckDigitISBN13(weightedSum);
		compareDigitsForISBN13(checkDigit, informedDigit);

	}

	private int getInformedDigitFromISBN13() {
		String extractedDigit = normalizedValue.substring(12, 13);
		int enteredDigit = Integer.parseInt(extractedDigit);
		return enteredDigit;
	}

	private int[] getFirstTwelveDigits() {
		String firstTwelveDigits = normalizedValue.substring(0, 12);
		int[] twelveDigits = firstTwelveDigits.chars().map(Character::getNumericValue).toArray();
		return twelveDigits;
	}

	private int calculateISBN13WeightedSum(int[] twelveDigits) {

		int weightedSum = 0;
		for (int i = 0; i < twelveDigits.length; i++) {

			if (i % 2 != 0) {
				weightedSum += twelveDigits[i] * 3;
			}
			else {
				weightedSum += twelveDigits[i] * 1;
			}
		}
		return weightedSum;
	}

	private int calculateCheckDigitISBN13(int digitsSum) {
		final int DIVISOR = 10;
		final int MINUEND = 10;
		int remainder = digitsSum % DIVISOR;
		int checkDigit = MINUEND - remainder;
		return checkDigit;
	}

	private void compareDigitsForISBN13(int checkDigit, int informedDigit) {
		// According to the ISBN-13 specification, a calculated value of 10 is
		// represented by check digit 0.
		if (checkDigit == 10) {
			checkDigit = 0;
		}

		if (checkDigit != informedDigit) {
			throw new IllegalArgumentException("ISBN-13 creation rejected. Invalid Check Digit.");
		}
	}

	// ISBN-10...............................................................................................
	private void verifyCheckDigitForISBN10() {
		int informedDigit = getInformedDigitFromISBN10();
		int[] nineDigits = getFirstNineDigits();
		int weightedSum = calculateISBN10WeightedSum(nineDigits);
		int checkDigit = calculateCheckDigitISBN10(weightedSum);
		compareDigitsForISBN10(checkDigit, informedDigit);

	}

	private int getInformedDigitFromISBN10() {

		String extractedDigit = normalizedValue.substring(9, 10);
		if (extractedDigit.equalsIgnoreCase("X")) {
			return 10;
		}
		return Integer.parseInt(extractedDigit);
	}

	private int[] getFirstNineDigits() {
		String firstNineDigits = normalizedValue.substring(0, 9);
		int[] nineDigits = firstNineDigits.chars().map(Character::getNumericValue).toArray();
		return nineDigits;
	}

	private int calculateISBN10WeightedSum(int[] nineDigits) {

		int weightedSum = 0;
		int n = 10;
		for (int i = 0; i < nineDigits.length; i++) {
			weightedSum += nineDigits[i] * n;
			n--;
		}
		return weightedSum;
	}

	private int calculateCheckDigitISBN10(int digitsSum) {
		final int DIVISOR = 11;
		int remainder = digitsSum % DIVISOR;
		int checkDigit = 11 - remainder;
		return checkDigit;
	}

	private void compareDigitsForISBN10(int checkDigit, int informedDigit) {

		if (checkDigit == 11) {
			checkDigit = 0;
		}
		if (checkDigit != informedDigit) {
			throw new IllegalArgumentException("ISBN-10 creation rejected. Invalid Check Digit.");
		}
	}
}
