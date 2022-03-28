package com.example.jwtbasicauth.payload.response;

import com.example.jwtbasicauth.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private Collection<Role> roles = new ArrayList<>();
}
