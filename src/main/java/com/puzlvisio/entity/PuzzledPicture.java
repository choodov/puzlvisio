package com.puzlvisio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by Chudov A.V. on 11/13/2016.
 */
@Getter
@Setter
public class PuzzledPicture {

	@DBRef
	private Picture picture;
	private long score;
	private long moves;
	private long totalTime;
	private int pieces;
	private boolean rotate;
	private boolean twoSides;
	@DBRef
	private Picture secondPicture;
	private Date created;

	public PuzzledPicture(){
		this.created = new Date();
	}

}
