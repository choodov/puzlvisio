package com.puzlvisio.service;

import com.puzlvisio.domain.entities.Gallery;

import java.util.List;

/**
 * Created by Chudov A.V. on 11/17/2016.
 */

public interface GalleryService {
	Gallery getById(String Id);

	List<Gallery> getGalleries();

	Gallery createGallery(Gallery gallery);
}
