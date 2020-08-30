package com.rosu.onlinestore.vo.response;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String account;
    private String name;
    private String role;


}
