package com.realscores.obj;

public enum FairwayHitEnum {
	
	YES   (1, "Yes"),
	LEFT  (2, "Left"),
	RIGHT (3, "Right"),
	SHORT (4, "Short"),
	LONG  (5, "Long");	
	
	private int id;
	private String description;
	
	private FairwayHitEnum(int id, String description){
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
