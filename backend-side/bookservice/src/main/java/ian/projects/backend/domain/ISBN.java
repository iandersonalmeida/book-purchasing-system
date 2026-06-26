package ian.projects.backend.domain;

/**
 * Represents the ISBN of a specific book edition.
 *
 * The ISBN is immutable and is normalized during creation.
 */
public class ISBN {

	private final String value;
	private final String normalizedValue;

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

	}
	public String getValue() {
		return normalizedValue;
	}
}
