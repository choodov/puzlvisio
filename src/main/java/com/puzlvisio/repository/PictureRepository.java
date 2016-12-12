package com.puzlvisio.repository;

import com.puzlvisio.domain.entities.Gallery;
import com.puzlvisio.domain.entities.Picture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

/**
 * Created by Chudov A.V. on 11/13/2016.
 */
//@RepositoryRestResource(collectionResourceRel = "picture", path = "picture")
public interface PictureRepository extends MongoRepository<Picture, String> {

	List<Picture> findByGallery(Gallery gallery);

}
