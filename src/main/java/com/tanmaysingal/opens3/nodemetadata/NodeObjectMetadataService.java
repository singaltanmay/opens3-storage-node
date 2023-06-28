package com.tanmaysingal.opens3.nodemetadata;

import com.tanmaysingal.opens3.models.NodeObjectMetadata;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeObjectMetadataService {

  @Autowired
  NodeObjectMetadataRepository repository;

  public Optional<NodeObjectMetadata> findByEtag(String etag) {
    return repository.findByEtag(etag);
  }
}
