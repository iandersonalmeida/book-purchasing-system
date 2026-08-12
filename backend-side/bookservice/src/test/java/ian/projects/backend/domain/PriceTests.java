package ian.projects.backend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.jupiter.api.Test;

public class PriceTests {

	@Test
	void shouldRejectZeroPrice() {

		// Given
		String amount = "0.00";
		Currency currency = Currency.getInstance("USD");

		// When
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> new Price(new BigDecimal(amount), currency));

		// Then
		assertEquals("Price is not bigger than zero.", exception.getMessage());
	}

	@Test
	void shouldRejectNegativePrice() {

		// Given
		String amount = "-5.00";
		Currency currency = Currency.getInstance("USD");

		// When
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> new Price(new BigDecimal(amount), currency));

		// Then
		assertEquals("Price is not bigger than zero.", exception.getMessage());
	}
	
	@Test
	void shouldRejectPriceWithoutCurrency() {
		
		//Given
		String amount = "10.00";
		Currency currency = null;
		
		//When
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> new Price(new BigDecimal(amount), currency));

		// Then
		assertEquals("Price should have a Currency.", exception.getMessage());
		
		
	}

}
