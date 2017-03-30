package com.puzlvisio.domain.entities;

import com.puzlvisio.domain.enums.GalleryTypeEnum;
import com.puzlvisio.domain.enums.StatusEnum;
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

	//TODO: add @Entity(noClassnameStored = true), and change @Id from id field to unique field (name for example)

	@Id private String id;
	private String name;
	private GalleryTypeEnum type;
	private StatusEnum status;
	private long amountOfPics;

}
