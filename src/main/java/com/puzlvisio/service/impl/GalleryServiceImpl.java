package com.puzlvisio.service.impl;

import com.puzlvisio.domain.entities.Gallery;
import com.puzlvisio.repository.GalleryRepository;
import com.puzlvisio.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chudov A.V. on 11/17/2016.
 */
@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	private GalleryRepository galleryRepository;

	@Override
	public Gallery getById(String Id) {
		return galleryRepository.findOne(Id);
	}

	@Override
	public List<Gallery> getGalleries() {
		return galleryRepository.findAll();
	}

	@Override
	public Gallery createGallery(Gallery gallery){
		return galleryRepository.save(gallery);
	}
}
