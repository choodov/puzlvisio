package com.puzlvisio.web;

import com.google.gson.Gson;
import com.puzlvisio.domain.entities.Picture;
import com.puzlvisio.service.GalleryService;
import com.puzlvisio.service.PictureService;
import com.puzlvisio.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.hateoas.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Chudov A.V. on 11/17/2016.
 */
@RestController
@RequestMapping(value = "/pictures")
@ExposesResourceFor(Picture.class)
public class PictureController {

	@Autowired
	private ImageUtil imageUtil;

	@Autowired
	private PictureService pictureService;

	@Autowired
	private GalleryService galleryService;

	@Autowired
	EntityLinks entityLinks;

	@GetMapping
	public Resources<Resource<Picture>> getPictures() {
		return pictureToResource(pictureService.getPictures());
	}

	@PostMapping
	public void savePicture(@RequestPart("json") String pictureJson,
							 @RequestPart("file") MultipartFile file) {
		Gson gson = new Gson();
		Picture picture = gson.fromJson(pictureJson, Picture.class);
		picture.setGallery(galleryService.getById(picture.getGallery().getId()));
		if (!file.isEmpty()) {
			Picture savedPicture = pictureService.createPicture(picture);
			imageUtil.savePictureImage(file, savedPicture);
		}
	}

	@RequestMapping(value = "/gallery/{galleryId}")
	public Resources<Resource<Picture>> getPicturesForGallery(@PathVariable String galleryId) {
		return pictureToResource(pictureService.getPicturesForGallery(galleryService.getById(galleryId)));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Resource<Picture> getPicture(@PathVariable String id) {
		return pictureToResource(pictureService.getById(id));
	}

	@RequestMapping(value = "/{id}/image", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getPictureImage(@PathVariable String id) {

		File file = imageUtil.getImage(pictureService.getById(id));

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //TODO: warning response
		}

		return ResponseEntity.ok()
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("image/jpeg"))
				.body(new InputStreamResource(inputStream));
	}

	private Resources<Resource<Picture>> pictureToResource(List<Picture> pictures) {
		Link selfLink = linkTo(methodOn(PictureController.class).getPictures()).withSelfRel();

		List<Resource<Picture>> picturesResources =
				pictures.stream().map(this::pictureToResource).collect(Collectors.toList());

		return new Resources<>(picturesResources, selfLink);
	}

	private Resource<Picture> pictureToResource(Picture picture) {
		Link selfLink = linkTo(methodOn(PictureController.class).getPicture(picture.getId())).withSelfRel();
		Link imageLink = linkTo(methodOn(PictureController.class).getPictureImage(picture.getId())).withRel("image");
		return new Resource<>(picture, selfLink, imageLink);
	}
}
