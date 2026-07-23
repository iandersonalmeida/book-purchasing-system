package ian.projects.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;

public class ISBNTests {

	// private static final Logger logger = LoggerFactory.getLogger(ISBN.class);

	@Test
	@DisplayName("Should reject null value")
	void shouldRejectNullValue() {

		// Given a invalid value
		String value = null;

		// When an ISBN is created using an invalid value
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));

		// Then the ISBN creation must be rejected
		Assertions.assertEquals("ISBN creation rejected. Value is null.", isbnCreation.getMessage());
	}

	@Test
	@DisplayName("Should reject blank value")
	void shouldRejectBlankValue() {
		// Given
		String value = "\t  ";
		// When
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));
		// Then
		Assertions.assertEquals("ISBN creation rejected. Value is blank.", isbnCreation.getMessage());
	}

	@Test
	@DisplayName("Should normalize hyphenated ISBN")
	void shouldNormalizeHyphenatedISBN() {
		// Given
		String value = "978-0-13-235088-4";
		// When
		ISBN isbn = new ISBN(value);
		// Then
		Assertions.assertEquals("9780132350884", isbn.getValue());
	}

	@Test
	@DisplayName("Should reject ISBN containing non digit characters")
	void shouldRejectISBNContainingNonDigitCharacters() {

		// Given
		String value = "978@132350884";
		// When
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));
		// Then
		Assertions.assertEquals("ISBN creation rejected. ISBN must contain digits.",
				isbnCreation.getMessage());

	}

	@Test
	@DisplayName("Should reject ISBN not containing 13 or 10 digits")
	void shouldRejectISBNNotContaining13or10Digits() {

		// Given
		String value = "123456789";
		// When
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));
		// Then
		Assertions.assertEquals("ISBN creation rejected. ISBN must be either a valid ISBN-10 or ISBN-13.",
				isbnCreation.getMessage());
	}

	@Test
	@DisplayName("Should verify invalid check digit for ISBN 13")
	void shouldVerifyInvalidCheckDigitForISBN13() {

		// Given
		String invalidValue = "9780132350885";
		// When
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(invalidValue));
		// Then
		Assertions.assertEquals("ISBN-13 creation rejected. Invalid Check Digit.", isbnCreation.getMessage());
	}

	@Test
	@DisplayName("Should verify valid check digit for ISBN 13")
	void shouldVerifyValidCheckDigitForISBN13() {

		// Given
		String validValue = "9780132350884";
		// When
		ISBN isbn = new ISBN(validValue);
		// Then
		Assertions.assertEquals("9780132350884", isbn.getValue());
	}

	@Test
	@DisplayName("Should create ISBN with check digit zero")
	void shouldCreateISBNWithCheckDigitZero() {

		// Given
		String value = "978-0-201-63361-0";
		// When
		ISBN isbn = new ISBN(value);
		// Then
		Assertions.assertEquals("9780201633610", isbn.getValue());
	}

	@Test
	@DisplayName("Should create ISBN 10 with valid check digit")
	void shouldCreateISBN10WithValidCheckDigit() {

		// Given
		String value = "0-13-110362-8";

		// When
		ISBN isbn = new ISBN(value);

		// Then
		Assertions.assertEquals("0131103628", isbn.getValue());

	}

	@Test
	@DisplayName("Should reject ISBN 10 with invalid check digit")
	void shouldRejectISBN10WithInvalidCheckDigit() {

		// Given
		String value = "0-13-110362-7";

		// When
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));
		// ISBN isbn = new ISBN(value);

		// Then
		Assertions.assertEquals("ISBN-10 creation rejected. Invalid Check Digit.", isbnCreation.getMessage());
		// Assertions.assertEquals("0131103628", isbn.getValue());
	}

	@Test
	@DisplayName("Should create ISBN 10 with check digit X")
	void shouldCreateISBN10WithCheckDigitX() {

		// Given
		String value = "0-8044-2957-X";

		// When
		ISBN isbn = new ISBN(value);

		// Then
		Assertions.assertEquals("080442957X", isbn.getValue());
	}

}
