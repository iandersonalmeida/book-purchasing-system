package ian.projects.backend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookEntityTests {

	@Test
	void shouldRejectNullTitle() {

		// Given
		String value = "978-0-596-52068-7";

		ISBN isbn = new ISBN(value);

		BigDecimal amount = new BigDecimal("10.00");

		Currency currency = Currency.getInstance("EUR");

		Price price = new Price(amount, currency);

		String author = "Eric Evans";

		String title = null;

		// When
		Exception bookEntityException = Assertions.assertThrows(IllegalArgumentException.class,
				() -> new BookEntity(isbn, title, author, price));

		// Then
		assertEquals("Book Creation rejected. Title can not be null.", bookEntityException.getMessage());

	}

	@Test
	void shouldRejectNullAuthor() {

		// Given
		String value = "978-0-596-52068-7";

		ISBN isbn = new ISBN(value);

		BigDecimal amount = new BigDecimal("10.00");

		Currency currency = Currency.getInstance("EUR");

		Price price = new Price(amount, currency);

		String author = null;

		String title = "Domain-Driven Design";

		// When
		Exception bookEntityException = Assertions.assertThrows(IllegalArgumentException.class,
				() -> new BookEntity(isbn, title, author, price));

		// Then
		assertEquals("Book Creation rejected. Author can not be null.", bookEntityException.getMessage());

	}

	@Test
	void shouldRejectNullPrice() {

		// Given
		String value = "978-0-596-52068-7";

		ISBN isbn = new ISBN(value);

		Price price = null;

		String author = "Eric Evans";

		String title = "Domain-Driven Design";

		// When
		Exception bookEntityException = Assertions.assertThrows(IllegalArgumentException.class,
				() -> new BookEntity(isbn, title, author, price));

		// Then
		assertEquals("Book Creation rejected. Price can not be null.", bookEntityException.getMessage());

	}

	@Test
	void shouldTestIfTwoBooksWithSameISBNAndSameStateAreEqual() {

		// Given Entity A
		String valueA = "978-0-596-52068-7";
		ISBN isbnA = new ISBN(valueA);
		BigDecimal amountA = new BigDecimal("10.00");
		Currency currencyA = Currency.getInstance("EUR");
		Price priceA = new Price(amountA, currencyA);
		String authorA = "Eric Evans";
		String titleA = "Domain-Driven Design";
		
		// Given Entity B
		String valueB = "978-0-596-52068-7";
		ISBN isbnB = new ISBN(valueB);
		BigDecimal amountB = new BigDecimal("10.00");
		Currency currencyB = Currency.getInstance("EUR");
		Price priceB = new Price(amountB, currencyB);
		String authorB = "Eric Evans";
		String titleB = "Domain-Driven Design";
		
		//When
		BookEntity bookEntityA = new BookEntity(isbnA, titleA, authorA, priceA);
		BookEntity bookEntityB = new BookEntity(isbnB, titleB, authorB, priceB);
		
		//Then
		assertEquals(bookEntityA, bookEntityB);
	}
	
	@Test
	void shouldTestIfTwoBooksWithSameISBNAndDifferentStateAreEqual() {

		// Given Entity A
		String valueA = "978-0-596-52068-7";
		ISBN isbnA = new ISBN(valueA);
		BigDecimal amountA = new BigDecimal("10.00");
		Currency currencyA = Currency.getInstance("EUR");
		Price priceA = new Price(amountA, currencyA);
		String authorA = "Eric Evans";
		String titleA = "Domain-Driven Design";
		
		// Given Entity B
		String valueB = "978-0-596-52068-7";
		ISBN isbnB = new ISBN(valueB);
		BigDecimal amountB = new BigDecimal("30.00");
		Currency currencyB = Currency.getInstance("EUR");
		Price priceB = new Price(amountB, currencyB);
		String authorB = "Eric Evans";
		String titleB = "Domain-Driven Design";
		
		//When
		BookEntity bookEntityA = new BookEntity(isbnA, titleA, authorA, priceA);
		BookEntity bookEntityB = new BookEntity(isbnB, titleB, authorB, priceB);
		
		//Then
		assertEquals(bookEntityA, bookEntityB);
	}
	
	@Test
	void shouldTestIfTwoBooksWithDifferentISBNAreDifferent() {

		// Given Entity A
		String valueA = "978-0-596-52068-7";
		ISBN isbnA = new ISBN(valueA);
		BigDecimal amountA = new BigDecimal("10.00");
		Currency currencyA = Currency.getInstance("EUR");
		Price priceA = new Price(amountA, currencyA);
		String authorA = "Eric Evans";
		String titleA = "Domain-Driven Design";
		
		// Given Entity B
		String valueB = "978-0-321-12521-7";
		ISBN isbnB = new ISBN(valueB);
		BigDecimal amountB = new BigDecimal("30.00");
		Currency currencyB = Currency.getInstance("EUR");
		Price priceB = new Price(amountB, currencyB);
		String authorB = "Eric Evans";
		String titleB = "Domain-Driven Design";
		
		//When
		BookEntity bookEntityA = new BookEntity(isbnA, titleA, authorA, priceA);
		BookEntity bookEntityB = new BookEntity(isbnB, titleB, authorB, priceB);
		
		//Then
		assertNotEquals(bookEntityA, bookEntityB);
	}
	
	@Test
	void shouldTestIfTwoBooksEqualHaveTheSameHashCode() {
		
		//Given Entity A
		String valueA = "978-0-596-52068-7";
		ISBN isbnA = new ISBN(valueA);
		BigDecimal amountA = new BigDecimal("10.00");
		Currency currencyA = Currency.getInstance("EUR");
		Price priceA = new Price(amountA, currencyA);
		String authorA = "Eric Evans";
		String titleA = "Domain-Driven Design";
		
		// Given Entity B
		String valueB = "978-0-596-52068-7";
		ISBN isbnB = new ISBN(valueB);
		BigDecimal amountB = new BigDecimal("30.00");
		Currency currencyB = Currency.getInstance("EUR");
		Price priceB = new Price(amountB, currencyB);
		String authorB = "Eric Evans";
		String titleB = "Domain-Driven Design";
		
		//When
		BookEntity bookEntityA = new BookEntity(isbnA, titleA, authorA, priceA);
		BookEntity bookEntityB = new BookEntity(isbnB, titleB, authorB, priceB);
		
		//Then
		assertEquals(bookEntityA.hashCode(), bookEntityB.hashCode());
		
		
	}

}
