package ian.projects.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ISBNTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ISBN.class);
	
	
	@Test
	void shouldNotAllowNullISBN() {
		
		
		//Given a invalid value
		String value = null;

		//When an ISBN is created using an invalid value
		Exception isbnCreation = Assertions.assertThrows(IllegalArgumentException.class, ()-> new ISBN(value));
	
		
		//Then the ISBN creation must be rejected
		Assertions.assertEquals("ISBN creation rejected", isbnCreation.getMessage());
		logger.info("ISBN creation rejected :"+isbnCreation);
		
	}
}
