package com.syc.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImgurImageUpload {

    private String image;
}
