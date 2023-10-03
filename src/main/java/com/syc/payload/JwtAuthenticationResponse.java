package com.syc.payload;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";

    private UserInfoResponse user;

    public JwtAuthenticationResponse(String accessToken, String refreshToken, UserInfoResponse user) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.user = user;
    }

}
