package com.example.jwtbasicauth.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserAddRoleRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String roleName;
}
