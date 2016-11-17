package com.puzlvisio.domain.enums;

public enum StatusEnum {
	ACTIVE, BLOCKED, DELETED;
	
	StatusEnum() {		
	}

	public String getName() {
		return this.name();
	}
}
