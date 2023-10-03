package com.syc.payload;

import lombok.Data;

@Data
public class ImgurResponse {
    private ImgurData data;
    private boolean success;
    private long status;

}
