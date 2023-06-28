package com.tanmaysingal.opens3.store;

import com.tanmaysingal.opens3.models.NodeObjectMetadata;
import com.tanmaysingal.opens3.nodemetadata.NodeObjectMetadataService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ChunkedStorageService implements StorageService {

  @Autowired
  NodeObjectMetadataService nodeObjectMetadataService;

  @Value("${opens3.storage.path}")
  private String drivePath;

  public String store(MultipartFile file) throws IOException {
    String filePath = getFilePath(file);
    file.transferTo(new File(filePath));
    return null;
  }

  private String getFilePath(MultipartFile file) {
    return drivePath + (drivePath.endsWith("/") ? "" : "/") + file.getOriginalFilename();
  }

  public byte[] fetch(String etag) {
    Optional<NodeObjectMetadata> metadata = nodeObjectMetadataService.findByEtag(etag);
    String filePath = metadata.get().getFilePath();
    byte[] images = new byte[0];
    try {
      images = Files.readAllBytes(new File(filePath).toPath());
    } catch (IOException e) {
      return null;
    }
    return images;
  }

}
