package com.puzlvisio.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Chudov A.V. on 11/13/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "galleries")
public class Gallery {

	@Id private String id;
	private String name;
	private String type;
	private String status;
	private long amountOfPics;

}
