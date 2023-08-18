package com.online.classroom.controller;

import com.online.classroom.model.Role;
import com.online.classroom.model.User;
import com.online.classroom.model.UserRole;
import com.online.classroom.payload.Response;
import com.online.classroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/v1/classroom/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/{username}")
    public ResponseEntity<Response> getUserByUserName(@PathVariable String username){
        UUID uuid = UUID.randomUUID();
        Response response = new Response(uuid.toString(), "Got Data for user id",this.userService.getUserByUserName(username));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable Long id){
         UUID uuid = UUID.randomUUID();
         Response response = new Response(uuid.toString(), "User delete with user id "+id);
         this.userService.deleteUser(id);
         return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateUserData(@PathVariable Long id, @RequestBody User user){
        UUID uuid = UUID.randomUUID();
        User updatedUser = this.userService.upsertUser(id, user);
        Response response = new Response(uuid.toString(), "User upserted with user id "+id, updatedUser);
        return ResponseEntity.ok(response);

    }
}
