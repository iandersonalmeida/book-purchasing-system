package ian.projects.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ISBNTests {

	private static final Logger logger = LoggerFactory.getLogger(ISBN.class);

	@Test
	void shouldRejectNullValue() {

		// Given a invalid value
		String value = null;

		// When an ISBN is created using an invalid value
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));

		// Then the ISBN creation must be rejected
		Assertions.assertEquals("ISBN creation rejected. Value is null.", isbnCreation.getMessage());
		logger.info("ISBN creation rejected :" + isbnCreation);

	}

	@Test
	void shouldRejectBlankValue() {
		String value = "\t  ";

		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));

		Assertions.assertEquals("ISBN creation rejected. Value is blank.", isbnCreation.getMessage());
		logger.info("ISBN creation rejected :" + isbnCreation);

	}

	@Test
	void shouldNormalizeHyphenatedISBN() {
		// Given
		String value = "978-0-13-235088-4";

		// When
		ISBN isbn = new ISBN(value);

		// Then
		Assertions.assertEquals("9780132350884", isbn.getValue());
		logger.info("Normalized ISBN :" + isbn.getValue());
	}

	@Test
	void shouldRejectISBNContainingNonDigitCharacters() {
		// Given
		String value = "978@132350884";

		// When
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, () -> new ISBN(value));

		// Then
		Assertions.assertEquals("ISBN creation rejected. ISBN must contain only digits.", isbnCreation.getMessage());
		logger.info("ISBN creation rejected :" + isbnCreation);
	}

}
