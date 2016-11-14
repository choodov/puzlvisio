package com.puzlvisio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Chudov A.V. on 11/13/2016.
 */
@Getter
@Setter
@Document(collection = "pictures")
public class Picture {

	@Id
	private String id;
	private String label;
	private String status;
	private long showings;
	private String accessType;
	private TS ts;
	@DBRef
	private Gallery gallery;

	public Picture(){
		this.ts = new TS();
	}

}
