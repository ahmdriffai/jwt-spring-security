package com.example.jwtbasicauth.payload.request;

import com.example.jwtbasicauth.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserSaveRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private List<Role> roles;
}
