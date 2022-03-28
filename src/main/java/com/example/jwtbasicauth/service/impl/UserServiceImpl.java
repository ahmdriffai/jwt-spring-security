package com.example.jwtbasicauth.service.impl;

import com.example.jwtbasicauth.entity.Role;
import com.example.jwtbasicauth.entity.User;
import com.example.jwtbasicauth.payload.request.RoleSaveRequest;
import com.example.jwtbasicauth.payload.request.UserAddRoleRequest;
import com.example.jwtbasicauth.payload.request.UserSaveRequest;
import com.example.jwtbasicauth.payload.response.RoleResponse;
import com.example.jwtbasicauth.payload.response.UserResponse;
import com.example.jwtbasicauth.repository.RoleRepository;
import com.example.jwtbasicauth.repository.UserRepository;
import com.example.jwtbasicauth.service.UserService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service @Transactional @NoArgsConstructor @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =     userRepository.findByUsername(username);
        if (user == null){
            log.error("Username not found in database");
            throw new UsernameNotFoundException("username not found");
        }else {
            log.error("Username found in database");
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    @Override
    public UserResponse saveUser(UserSaveRequest userRequest) {
        log.info("Save new user");
        User user = new User(null, userRequest.getUsername(), userRequest.getPassword(), userRequest.getRoles());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User userResponse = userRepository.save(user);

        return new UserResponse(userResponse.getId(), userResponse.getUsername(), userResponse.getRoles());
    }

    @Override
    public RoleResponse saveRole(RoleSaveRequest roleRequest) {
        log.info("Save new role {} to database", roleRequest.getName());

        Role role = new Role(null, roleRequest.getName());
        Role saveRole = roleRepository.save(role);

        return new RoleResponse(role.getId(),role.getName());
    }

    @Override
    public void addRoleToUser(UserAddRoleRequest request) {
        log.info("Add role {} to user {}", request.getRoleName(), request.getUsername());

        User user = userRepository.findByUsername(request.getUsername());
        Role role = roleRepository.findByName(request.getRoleName());

        user.getRoles().add(role);
    }

    @Override
    public UserResponse getUser(String username) {
        log.info("Fetch user {}", username);
        User user = userRepository.findByUsername(username);

        return new UserResponse(user.getId(),user.getUsername(),user.getRoles());
    }

    @Override
    public List<UserResponse> getUsers() {
        log.info("Fetch all users");
        return userRepository.findAll()
                .stream().map(
                        user -> new UserResponse(
                                user.getId(),
                                user.getUsername(),
                                user.getRoles()
                        )).collect(Collectors.toList());

    }


}
