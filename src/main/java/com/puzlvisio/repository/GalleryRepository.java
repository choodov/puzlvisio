package com.puzlvisio.repository;

import com.puzlvisio.domain.entities.Gallery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Chudov A.V. on 11/13/2016.
 */
//@RepositoryRestResource(collectionResourceRel = "gallery", path = "gallery")
public interface GalleryRepository extends MongoRepository<Gallery, String> {
}
