package ian.projects.backend.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

		validatePriceIsBiggerThanZero(amount);

		validateCurrency(currency);

		validateNumberOfDecimalPlaces(amount);

		this.amount = normalizePrice(amount);

		this.currency = currency;

		// stateOfTheObject();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	private void validatePriceIsBiggerThanZero(BigDecimal amount) {

		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Price is not bigger than zero.");
		}
	}

	private void validateCurrency(Currency currency) {

		if (currency == null) {
			throw new IllegalArgumentException("Price should have a Currency.");
		}
	}

	private void validateNumberOfDecimalPlaces(BigDecimal amount) {

		int numberOfDecimalPlaces = amount.scale();

		if (numberOfDecimalPlaces > 2) {
			throw new IllegalArgumentException("Price can not have more than two decimal places.");
		}
	}

	private BigDecimal normalizePrice(BigDecimal value) {		
		
		BigDecimal amount = value.setScale(2, RoundingMode.UNNECESSARY );

		return amount;
	}

	/*
	 * private void stateOfTheObject() { System.out.println("Amount: "+amount);
	 * System.out.println("Currency: "+currency); }
	 */

}
