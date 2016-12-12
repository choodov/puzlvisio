package com.puzlvisio.service;

import com.puzlvisio.domain.entities.Picture;

import java.util.List;

/**
 * Created by Chudov A.V. on 11/17/2016.
 */
public interface PictureService {
	Picture getById(String Id);

	List<Picture> getPictures();

	Picture createPicture(Picture picture);
}
