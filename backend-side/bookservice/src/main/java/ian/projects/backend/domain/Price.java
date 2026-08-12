package ian.projects.backend.domain;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Represents the Price of a book.
 *
 * The Price is immutable.
 */
public final class Price {

	private final BigDecimal amount;
	private final Currency currency;

	public Price(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;

		// invariant 1
		validatePriceIsBiggerThanZero();
		
		// invariant 2
		validateCurrency();
	}

	private void validatePriceIsBiggerThanZero() {

		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Price is not bigger than zero.");
		}
	}
	
	private void validateCurrency() {
		
		if(currency == null) {
			throw new IllegalArgumentException("Price should have a Currency.");
		}
	}

}
