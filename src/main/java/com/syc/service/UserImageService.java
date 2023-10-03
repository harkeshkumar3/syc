package com.syc.service;

import com.syc.exception.ResourceNotFoundException;
import com.syc.model.User;
import com.syc.model.UserImages;
import com.syc.payload.ImgurData;
import com.syc.payload.ImgurResponse;
import com.syc.repository.UserImagesRepository;
import com.syc.repository.UserRepository;
import com.syc.security.UserDetailsImpl;
import com.syc.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserImageService {
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final UserImagesRepository userImagesRepository;

    public void addImageInfo(String token, ImgurData data) {
        String userNameFromJwtToken = jwtUtils.getUserNameFromToken(token);
        log.info("username found to update image ={}", userNameFromJwtToken);
        User user = userRepository.findByUsername(userNameFromJwtToken)
                .orElseThrow(() -> new ResourceNotFoundException("username not found"));

        UserImages userImages = UserImages.builder()
                .name(data.getName())
                .userId(user.getId())
                .hashcode(data.getId())
                .deleteHashcode(data.getDeletehash())
                .build();
        userImagesRepository.save(userImages);
    }

    public List<UserImages> getUserImagesList(UserDetailsImpl userDetails) {
        log.info("user id = {} ", userDetails.getId());
        return userImagesRepository.findByUserId(userDetails.getId());
    }
}
