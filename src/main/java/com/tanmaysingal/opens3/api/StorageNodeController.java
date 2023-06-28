package com.tanmaysingal.opens3.api;

import com.tanmaysingal.opens3.store.StorageService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class StorageNodeController {

  @Autowired
  private StorageService storageService;

  @PostMapping("/object")
  public ResponseEntity<?> store(@RequestParam("file") MultipartFile file) throws IOException {
    String uploadImage = storageService.store(file);
    return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
  }

  @GetMapping("/object/{fileName}")
  public ResponseEntity<?> fetch(@PathVariable String fileName) throws IOException {
    byte[] object = storageService.fetch(fileName);
    if (object == null || object.length == 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.OK).body(object);
  }
}
