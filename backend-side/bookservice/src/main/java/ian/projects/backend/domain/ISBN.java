package ian.projects.backend.domain;

/**
 * Represents the ISBN of a specific book edition.
 *
 * The ISBN is immutable and is normalized during creation.
 */
public class ISBN {

	private final String value;
	private final String normalizedValue;
	private static final int ISBN_LENGTH_10 = 10;
	private static final int ISBN_LENGTH_13 = 13;

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
		
		if(normalizedValue.length() != ISBN_LENGTH_10 && normalizedValue.length() != ISBN_LENGTH_13) {
			throw new IllegalArgumentException("ISBN creation rejected. ISBN muss contain exactly 10 or 13 digits.");
		}			
	
	} 
	public String getValue() {
		return normalizedValue;
	}
	
	private final String isbnCreationMessage() {
		return "ISBN Created Successfully!";
	}
}
