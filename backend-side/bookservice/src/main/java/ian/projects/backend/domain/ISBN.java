package ian.projects.backend.domain;

//This class represent an ISBN. 
public class ISBN {
	
	private final String value;

	public ISBN(String value) {
		this.value = value;
		if(value == null) {
			throw new IllegalArgumentException("ISBN creation rejected. Value is null.");
		}
		
		else if(value.equals("")) {
			throw new IllegalArgumentException("ISBN creation rejected. Value is empty.");			
		}
	}


}
