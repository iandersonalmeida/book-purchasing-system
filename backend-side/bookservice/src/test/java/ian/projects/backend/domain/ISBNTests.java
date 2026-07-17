package ian.projects.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ISBNTests {

	private static final Logger logger = LoggerFactory.getLogger(ISBN.class);

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
		//Given
		String value = "\t  ";
		//When
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));
		//Then
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
		//logger.info("TEST: Should reject ISBN containing non digit characters");
		
		// Given
		String value = "978@132350884";
		// When
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));
		// Then
		Assertions.assertEquals("ISBN creation rejected. ISBN must contain only digits.", isbnCreation.getMessage());
		
	}

	@Test
	@DisplayName("Should reject ISBN not containing 10 or 13 digits")
	void shouldRejectISBNNotContaining10Or13Digits() {
		//logger.info("TEST: Should reject ISBN not containing 10 or 13 digits");

		// Given
		String value = "123456789";
		// When
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));
		// Then
		Assertions.assertEquals("ISBN creation rejected. ISBN muss contain exactly 10 or 13 digits.",
				isbnCreation.getMessage());
		
	}

	@Test
	@DisplayName("Should verify invalid check digit")
	void shouldVerifyInvalidCheckDigit() {
		//logger.info("TEST: Should verify invalid check digit");

		// Given
		String invalidValue = "9780132350885";
		// When
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(invalidValue));
		// Then
		Assertions.assertEquals("ISBN creation rejected. Invalid Digit.", isbnCreation.getMessage());
		logger.info("ISBN creation rejected :" + isbnCreation);
	}

	@Test
	@DisplayName("Should verify valid check digit")
	void shouldVerifyValidCheckDigit() {
		//logger.info("TEST: Should verify valid check digit");

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

		//logger.info("TEST: Should create ISBN with check digit zero");

		// Given
		String value = "978-0-201-63361-0";
		// When
		ISBN isbn = new ISBN(value);
		// Then
		Assertions.assertEquals("9780201633610", isbn.getValue());
	}

}
