package com.tanmaysingal.opens3.nodemetadata;

import com.tanmaysingal.opens3.models.NodeObjectMetadata;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeObjectMetadataRepository extends JpaRepository<NodeObjectMetadata, UUID> {

  Optional<NodeObjectMetadata> findByEtag(String etag);
}
