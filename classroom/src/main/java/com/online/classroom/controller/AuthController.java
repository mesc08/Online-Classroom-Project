package com.online.classroom.controller;

import com.online.classroom.model.Role;
import com.online.classroom.model.User;
import com.online.classroom.model.UserRole;
import com.online.classroom.payload.JwtRequest;
import com.online.classroom.payload.JwtResponse;
import com.online.classroom.payload.Response;
import com.online.classroom.service.implementation.UserDetailsServiceImpl;
import com.online.classroom.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.jwt.example.sercurity.JwtHelper;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private  JwtHelper helper;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
        this.doAuthenticate(request.getUserName(), request.getPassword());
        User userDetails = (User) userDetailsService.loadUserByUsername(request.getUserName());
        String token = this.helper.generateToken(userDetails);
        JwtResponse response = new JwtResponse(token,  userDetails.getUsername());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String username, String password){
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try{
            manager.authenticate(authentication);
        } catch (BadCredentialsException exp){
            throw new BadCredentialsException("Invalid Username or Password !!");
        }
    }


    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

    @PostMapping("/create-user")
    public ResponseEntity<Response> createUser(@RequestBody User user) throws Exception{
        user.setProfile("default.png");
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setId(45L);
        role.setRoleName("NORMAL");
        UUID uuid = UUID.randomUUID();
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        Response response = new Response(uuid.toString(), "Data Save Successfully", this.userService.createUser(user, roles));
        return ResponseEntity.ok(response);
    }
}
