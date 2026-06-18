package ian.projects.backend.domain;

public final class ISBN {

	private final String value;

	public ISBN(String value) {
		this.value = value;
		if(value == null) {
			throw new IllegalArgumentException("ISBN creation rejected");
		}
	}

}
