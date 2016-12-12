package com.puzlvisio.repository;

import com.puzlvisio.domain.entities.Picture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Chudov A.V. on 11/13/2016.
 */
//@RepositoryRestResource(collectionResourceRel = "picture", path = "picture")
public interface PictureRepository extends MongoRepository<Picture, String> {
}
