package com.rosu.onlinestore.vo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

    @Data
    public class LoginForm {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
        @NotBlank
        private String email;

    }



