package com.tanmaysingal.opens3.store;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

  String store(MultipartFile file) throws IOException;

  byte[] fetch(String fileName) throws IOException;

}
