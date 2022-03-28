package com.example.jwtbasicauth;

import com.example.jwtbasicauth.entity.Role;
import com.example.jwtbasicauth.payload.request.RoleSaveRequest;
import com.example.jwtbasicauth.payload.request.UserAddRoleRequest;
import com.example.jwtbasicauth.payload.request.UserSaveRequest;
import com.example.jwtbasicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtBasicAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtBasicAuthApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
//	@Bean
//	CommandLineRunner runner(UserService userService){
//		return args -> {
//			userService.saveRole(new RoleSaveRequest("ROLE_USER"));
//			userService.saveRole(new RoleSaveRequest("ROLE_ADMIN"));
//			userService.saveRole(new RoleSaveRequest("ROLE_DOSEN"));
//			userService.saveRole(new RoleSaveRequest("ROLE_MAHASIWA"));
//
//			userService.saveUser(new UserSaveRequest("rifai","rahasia", new ArrayList<>()));
//			userService.saveUser(new UserSaveRequest("paijo","rahasia", new ArrayList<>()));
//			userService.saveUser(new UserSaveRequest("selamet","rahasia", new ArrayList<>()));
//			userService.saveUser(new UserSaveRequest("jring","rahasia", new ArrayList<>()));
//
//			userService.addRoleToUser(new UserAddRoleRequest("rifai", "ROLE_ADMIN"));
//			userService.addRoleToUser(new UserAddRoleRequest("paijo", "ROLE_USER"));
//			userService.addRoleToUser(new UserAddRoleRequest("selamet", "ROLE_DOSEN"));
//			userService.addRoleToUser(new UserAddRoleRequest("jring", "ROLE_MAHASISWA"));
//			userService.addRoleToUser(new UserAddRoleRequest("rifai", "ROLE_DOSEN"));
//		};
//	}
}
