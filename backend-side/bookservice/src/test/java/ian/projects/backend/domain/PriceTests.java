package ian.projects.backend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

		// Given
		String amount = "10.00";
		Currency currency = null;

		// When
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> new Price(new BigDecimal(amount), currency));

		// Then
		assertEquals("Price should have a Currency.", exception.getMessage());
	}

	@Test
	void shouldRejectPriceWithMoreThanTwoDecimalPlaces() {

		// Given
		String amount = "10.999";
		Currency currency = Currency.getInstance("USD");

		// When
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> new Price(new BigDecimal(amount), currency));
		// Then
		assertEquals("Price can not have more than two decimal places.", exception.getMessage());
	}

	@Test
	void shouldNormalizePriceToTwoDecimalPlaces() {

		// Given
		String amount = "10.0";
		Currency currency = Currency.getInstance("USD");

		// When
		Price price = new Price(new BigDecimal(amount), currency);

		// Then
		assertEquals(new BigDecimal("10.00"), price.getAmount());
	}

	@Test
	void shouldConsiderPricesEqualWhenAmountAndCurrencyAreEqual() {

		// Given
		String amount = "10.00";
		Currency currency = Currency.getInstance("USD");

		// When
		Price aPrice = new Price(new BigDecimal(amount), currency);
		Price bPrice = new Price(new BigDecimal(amount), currency);

		// Then
		assertEquals(aPrice, bPrice);

	}

	@Test
	void shouldConsiderDifferentPricesWhenCurrenciesAreDifferent() {

		// Given
		String amount = "10.00";
		Currency currency1 = Currency.getInstance("USD");
		Currency currency2 = Currency.getInstance("EUR");

		// When
		Price aPrice = new Price(new BigDecimal(amount), currency1);
		Price bPrice = new Price(new BigDecimal(amount), currency2);

		// Then
		assertNotEquals(aPrice, bPrice);

	}

	@Test
	void shouldConsiderDifferentPricesWhenAmountsAreDifferent() {

		// Given
		String amount1 = "10.00";
		String amount2 = "20.00";
		Currency currency = Currency.getInstance("EUR");

		// When
		Price aPrice = new Price(new BigDecimal(amount1), currency);
		Price bPrice = new Price(new BigDecimal(amount2), currency);

		// Then
		assertNotEquals(aPrice, bPrice);

	}

	@Test
	void shouldConsiderEqualPricesWhenInputRepresentationsAreNotEqual() {

		// Given
		String amount1 = "10";
		String amount2 = "10.0";
		Currency currency = Currency.getInstance("EUR");

		// When
		Price aPrice = new Price(new BigDecimal(amount1), currency);
		Price bPrice = new Price(new BigDecimal(amount2), currency);

		// Then
		assertEquals(aPrice, bPrice);

	}

	@Test
	void shouldHaveSameHashCodeWhenPricesAreEqual() {

		// Given
		String amount1 = "10";
		String amount2 = "10.00";
		Currency currency = Currency.getInstance("EUR");

		// When
		Price aPrice = new Price(new BigDecimal(amount1), currency);
		Price bPrice = new Price(new BigDecimal(amount2), currency);

		// Then
		assertEquals(aPrice.hashCode(), bPrice.hashCode());

	}

}
