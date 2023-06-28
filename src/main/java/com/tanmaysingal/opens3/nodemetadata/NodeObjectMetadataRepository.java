package com.tanmaysingal.opens3.nodemetadata;

import com.tanmaysingal.opens3.models.NodeObjectMetadata;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeObjectMetadataRepository extends JpaRepository {

  Optional<NodeObjectMetadata> findByEtag(String etag);
}
