package com.puzlvisio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by Chudov A.V. on 11/13/2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class Friend {

	@DBRef
	private User user;
	private String acceptStatus;

}
