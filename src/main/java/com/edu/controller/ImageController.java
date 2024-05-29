package com.edu.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ImageController {
	// Path to the directory where photos are stored
    private static final String PHOTO_DIRECTORY = "C://Kashish//Educonnect//ImageFolder/";

    @GetMapping("/api/photo/{photoName}")
    public ResponseEntity<Resource> getPhoto(@PathVariable String photoName, @RequestParam String username) throws IOException {
        Path userDirectory = Paths.get(PHOTO_DIRECTORY + username);
        Path photoPath = userDirectory.resolve(photoName);
 

        if (Files.exists(photoPath) && !Files.isDirectory(photoPath)) {
            Resource photoResource = new FileSystemResource(photoPath);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + photoName + "\"")
                    .body(photoResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
