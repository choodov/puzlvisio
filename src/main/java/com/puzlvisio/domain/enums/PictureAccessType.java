package com.puzlvisio.domain.enums;

/**
 * Created by Chudov A.V. on 11/29/2016.
 */
public enum PictureAccessType {
	PRIVATE, FRIENDS, ALL;

	PictureAccessType(){}

	public String getName() {
		return this.name();
	}
}
