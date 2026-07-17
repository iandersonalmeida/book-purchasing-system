package ian.projects.backend.domain;

import java.util.Arrays;
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

		if (this.value == null) {
			throw new IllegalArgumentException("ISBN creation rejected. Value is null.");
		}

		if (this.value.isBlank()) {
			throw new IllegalArgumentException("ISBN creation rejected. Value is blank.");
		}

		// Hyphens are accepted as input but are not part of the ISBN identity.
		this.normalizedValue = value.replace("-", "");

		// After normalization, an ISBN must contain only digit characters.
		if (!normalizedValue.matches("[0-9]+")) {
			throw new IllegalArgumentException("ISBN creation rejected. ISBN must contain only digits.");
		}

		if (normalizedValue.length() != ISBN_LENGTH_10 && normalizedValue.length() != ISBN_LENGTH_13) {
			throw new IllegalArgumentException("ISBN creation rejected. ISBN muss contain exactly 10 or 13 digits.");
		}
		verifyCheckDigit();
	}

	public String getValue() {
		return normalizedValue;
	}

	private void verifyCheckDigit() {

		int informedDigit = getInformedDigit();
		int[] twelveDigits = getFirstTwelveDigits();
		int digitsSum = multiplyDigitsByWeightsAndSumAllProducts(twelveDigits);
		int checkDigit = calculateCheckDigit(digitsSum);
		compareDigits(checkDigit, informedDigit);

	}

	private int getInformedDigit() {
		String extractedDigit = normalizedValue.substring(12, 13);
		int enteredDigit = Integer.parseInt(extractedDigit);
		return enteredDigit;
	}

	private int[] getFirstTwelveDigits() {
		String firstTwelveDigits = normalizedValue.substring(0, 12);
		int[] twelveDigits = firstTwelveDigits.chars().map(Character::getNumericValue).toArray();
		return twelveDigits;
	}

	private int multiplyDigitsByWeightsAndSumAllProducts(int[] twelveDigits) {

		int[] evenIndices = IntStream.range(0, twelveDigits.length).filter(i -> i % 2 == 0).map(i -> twelveDigits[i])
				.toArray();

		int[] oddIndices = IntStream.range(0, twelveDigits.length).filter(i -> i % 2 != 0).map(i -> twelveDigits[i])
				.toArray();

		int[] evenIndexedDigits = new int[6];
		for (int i = 0; i < evenIndices.length; i++) {
			evenIndexedDigits[i] = evenIndices[i] * 1;

		}

		int[] oddIndexedDigits = new int[6];
		for (int i = 0; i < oddIndices.length; i++) {
			oddIndexedDigits[i] = oddIndices[i] * 3;

		}

		int digitsSum = 0;
		for (int i = 0; i < evenIndexedDigits.length; i++) {
			digitsSum += evenIndexedDigits[i] + oddIndexedDigits[i];
		}

		return digitsSum;
	}

	private int calculateCheckDigit(int digitsSum) {
		final int DIVISOR = 10;
		final int MINUEND = 10;
		int remainder = digitsSum % DIVISOR;
		int checkDigit = MINUEND - remainder;
		return checkDigit;
	}

	private void compareDigits(int checkDigit, int informedDigit) {
		// According to the ISBN-13 specification, a calculated value of 10 is represented by check digit 0.
		if (checkDigit == 10) {
			checkDigit = 0;			
		}

		if (checkDigit != informedDigit) {
			throw new IllegalArgumentException("ISBN creation rejected. Invalid Digit.");
		}

		System.out.println("ISBN created successfully.");
	}
}
