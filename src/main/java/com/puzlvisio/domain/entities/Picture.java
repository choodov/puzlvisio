package com.puzlvisio.domain.entities;

import com.puzlvisio.domain.enums.PictureAccessType;
import com.puzlvisio.domain.enums.StatusEnum;
import lombok.Getter;
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
	private StatusEnum status;
	private long showings;
	private PictureAccessType accessType;
	private TS ts;
	@DBRef
	private Gallery gallery;

	public Picture(){
		this.ts = new TS();
	}

}
