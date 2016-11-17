package com.puzlvisio.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Chudov A.V. on 11/13/2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class AdvInfo {

	private long totalShowings;
	private int maxPictures;
	private String address;
	private String additional;

}
