package com.puzlvisio.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Chudov A.V. on 11/13/2016.
 */
@Getter
@Setter
public class TS {

	private Date created;
	private Date modified;

	public TS() {
		this.created = new Date();
		this.modified = new Date();
	}

}
