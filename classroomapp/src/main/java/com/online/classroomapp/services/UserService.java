package com.online.classroomapp.services;

import com.online.classroomapp.models.User;
import com.online.classroomapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)  {
                return userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("user name not found"));
            }
        };
    }

    public User save(User newUser){
        if(newUser.getId() == null){
            newUser.setCreatedAt(LocalDateTime.now());
        }
        newUser.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(newUser);
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public void deleteUser(String username){
        User user = this.userRepository.findByEmail(username).orElse(null);
        this.userRepository.deleteById(user.getId());
    }

    public User getUserById(Long id){
        return this.userRepository.findById(id).orElse(null);
    }



}
