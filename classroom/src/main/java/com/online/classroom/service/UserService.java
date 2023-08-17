package com.online.classroom.service;

import com.online.classroom.model.User;
import com.online.classroom.model.UserRole;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUserByUserName(String username);

    public void deleteUser(Long userid);

    User upsertUser(Long id, User user);
}
