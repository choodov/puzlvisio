package com.puzlvisio.service.impl;

import com.puzlvisio.domain.entities.Picture;
import com.puzlvisio.repository.PictureRepository;
import com.puzlvisio.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chudov A.V. on 11/17/2016.
 */
@Service
public class PictureServiceImpl implements PictureService{

	@Autowired
	private PictureRepository pictureRepository;

	@Override
	public Picture getById(String Id) {
		return pictureRepository.findOne(Id);
	}

	@Override
	public List<Picture> getPictures() {
		return pictureRepository.findAll();
	}

	@Override
	public Picture createPicture(Picture picture) {
		return pictureRepository.save(picture);
	}
}
