package com.syc.service;

import com.syc.payload.ImgurResponse;
import com.syc.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    private final ImageRepository imageRepository;


    private String auth = "Client-ID d2389e11bdb30ef";

    public ImgurResponse storeFile(MultipartFile file) throws IOException, URISyntaxException {
        byte[] fileContent = FileUtils.readFileToByteArray(convertMultiPartToFile(file));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return imageRepository.upload(encodedString, auth);
    }

    public ImgurResponse getImage(String id) {
        return imageRepository.getImage(id, auth);
    }

    public ImgurResponse deleteImage(String code) {
        return imageRepository.deleteImage(code, auth);
    }


    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
