package com.puzlvisio.web;

import com.google.gson.Gson;
import com.puzlvisio.domain.entities.Gallery;
import com.puzlvisio.service.GalleryService;
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
 * Created by Chudov A.V. on 11/24/2016.
 */
@RestController
@RequestMapping(value = "/galleries")
@ExposesResourceFor(Gallery.class)
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	@Autowired
	EntityLinks entityLinks;

	@Autowired
	private ImageUtil imageUtil;

	@GetMapping
	public Resources<Resource<Gallery>> getGalleries() {
		return galleryToResource(galleryService.getGalleries());
	}

	@PostMapping
	public void saveGallerry(@RequestPart("json") String galleryJson,
							 @RequestPart("file") MultipartFile file) {

		Gson gson = new Gson();
		Gallery gallery = gson.fromJson(galleryJson, Gallery.class);
		if (!file.isEmpty()) {
			imageUtil.saveGallery(file, gallery);
			galleryService.createGallery(gallery);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Resource<Gallery> getGallery(@PathVariable String id) {
		return galleryToResource(galleryService.getById(id));
	}

	@RequestMapping(value = "/{id}/image", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getGalleryImage(@PathVariable String id) {

		File file = imageUtil.getGalleryImage(galleryService.getById(id));

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

	private Resources<Resource<Gallery>> galleryToResource(List<Gallery> galleries) {
		Link selfLink = linkTo(methodOn(GalleryController.class).getGalleries()).withSelfRel();

		List<Resource<Gallery>> galleryResources =
				galleries.stream().map(this::galleryToResource).collect(Collectors.toList());

		return new Resources<>(galleryResources, selfLink);
	}

	private Resource<Gallery> galleryToResource(Gallery gallery) {
		Link selfLink = linkTo(methodOn(GalleryController.class).getGallery(gallery.getId())).withSelfRel();
		Link imageLink = linkTo(methodOn(GalleryController.class).getGalleryImage(gallery.getId())).withRel("image");
//		Link entityLinksExample = entityLinks.linkToCollectionResource(SomeClass.class).withRel("all-entities");
		return new Resource<>(gallery, selfLink, imageLink /*, entityLinksExample*/);
	}

}
