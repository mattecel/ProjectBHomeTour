package fixtures;

public abstract class Fixture {
	
	private String name;
	private String shortDescription;
	private String longDescription;
	
	public Fixture(String aName, String aShortDescription, String aLongDescription) {
		this.name = aName;
		this.shortDescription = aShortDescription;
		this.longDescription = aLongDescription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

}
