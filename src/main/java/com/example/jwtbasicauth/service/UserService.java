package com.example.jwtbasicauth.service;

import com.example.jwtbasicauth.payload.request.RoleSaveRequest;
import com.example.jwtbasicauth.payload.request.UserAddRoleRequest;
import com.example.jwtbasicauth.payload.request.UserSaveRequest;
import com.example.jwtbasicauth.payload.response.RoleResponse;
import com.example.jwtbasicauth.payload.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse saveUser(UserSaveRequest userRequest);
    RoleResponse saveRole(RoleSaveRequest roleRequest);
    void addRoleToUser(UserAddRoleRequest request);
    UserResponse getUser(String username);
    List<UserResponse> getUsers();
}
