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
	public static final int DIVISOR = 10;
	public static final int MINUEND = 10;

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

		// Extract digit
		String extractedDigit = normalizedValue.substring(12, 13);

		// Convert to int
		int enteredDigit = Integer.parseInt(extractedDigit);

		String first12Digits = normalizedValue.substring(0, 12);
		//System.out.println("First 12 digits: " + first12Digits);
		
		//Convert to int
		int[] digits = first12Digits.chars().map(Character::getNumericValue).toArray();
		//System.out.println("Digits: " + Arrays.toString(digits));
		
		//Extract the values ​​of the even indices
		int[] evenIndices = IntStream.range(0, digits.length).filter(i -> i % 2 == 0).map(i -> digits[i]).toArray();
		//System.out.println("Even Indices Values: " + Arrays.toString(evenIndices));
		
		//Extract the values ​​of the odd indices
		int[] oddIndices = IntStream.range(0, digits.length).filter(i -> i % 2 != 0).map(i -> digits[i]).toArray();
		//System.out.println("Odd Indices Values: " + Arrays.toString(oddIndices));

		// Computed values of even indices
		int[] evenIndexedDigits = new int[6];
		for (int i = 0; i < evenIndices.length; i++) {
			evenIndexedDigits[i] = evenIndices[i] * 1;
			//String computedEvenvalues = Arrays.toString(evenIndexedDigits);
			//System.out.println("Computed values of even indices: " + computedEvenvalues);
		}

		// Computed values of odd indices
		int[] oddIndexedDigits = new int[6];
		for (int i = 0; i < oddIndices.length; i++) {
			oddIndexedDigits[i] = oddIndices[i] * 3;
			//String computedOddvalues = Arrays.toString(oddIndexedDigits);
			//System.out.println("Computed values of odd indices: " + computedOddvalues);
		}

		// Sum of digits
		int digitsSum = 0;
		for (int i = 0; i < evenIndexedDigits.length; i++) {
			digitsSum += evenIndexedDigits[i] + oddIndexedDigits[i];
		}

		System.out.println("Result: " + digitsSum);

		// Divide sum of digits by 10
		int remainder = digitsSum % DIVISOR;
		System.out.println("remainder: " +remainder);

		// Take the remainder and subtract it from 10 to obtain the check digit.
		int checkDigit = MINUEND - remainder;
		System.out.println("Check Digit: " + checkDigit);
		System.out.println("Entered Digit: " + enteredDigit);
		
		//special case if check digit is 10
		if(checkDigit == 10) {
			checkDigit = 0;
			System.out.println("Check digit changed from 10 to 0. Check digit = " +checkDigit);
		}
		
		

		if (checkDigit != enteredDigit) {
			throw new IllegalArgumentException("ISBN creation rejected. Invalid Digit.");
		}	
		
		System.out.println("ISBN created successfully.");

	}
}
