package com.syc.repository;

import com.syc.payload.ImgurResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;

@Repository
public class ImageRepository {

    @Value("${syc.app.imgur.server: https://api.imgur.com}")
    private String imgurServer;

    public ImgurResponse upload(String base64, String auth) throws URISyntaxException {
        WebClient client = WebClient.create();
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("image", base64);
        return client.post()
                .uri(new URI(imgurServer + "/3/image"))
                .header("Authorization", auth)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(ImgurResponse.class)
                .block();
    }

    public ImgurResponse getImage(String imageHashCode, String auth) {
        WebClient client = WebClient.create();
        return client.get()
                .uri(imgurServer + "/3/image/" + imageHashCode)
                .header("Authorization", auth)
                .retrieve()
                .bodyToMono(ImgurResponse.class)
                .block();
    }

    public ImgurResponse deleteImage(String imageHashCode, String auth) {
        WebClient client = WebClient.create();
        return client.delete()
                .uri(imgurServer + "/3/image/" + imageHashCode)
                .header("Authorization", auth)
                .retrieve()
                .bodyToMono(ImgurResponse.class)
                .block();
    }

}
