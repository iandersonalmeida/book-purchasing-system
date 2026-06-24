package ian.projects.backend.domain;

//This class represent an ISBN. 
public class ISBN {
	
	private final String value;
	private final String normalizedValue;

	public ISBN(String value) {
		this.value = value;
		if(this.value == null) {
			throw new IllegalArgumentException("ISBN creation rejected. Value is null.");
		}		
		
		if(this.value.isBlank()){
			throw new IllegalArgumentException("ISBN creation rejected. Value is blank.");	
		}
		
		this.normalizedValue = value.replace("-","");		
	}
	
	public String getValue() {
		return normalizedValue;
	}
}
