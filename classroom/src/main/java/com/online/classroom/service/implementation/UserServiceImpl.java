package com.online.classroom.service.implementation;

import com.online.classroom.model.User;
import com.online.classroom.model.UserRole;
import com.online.classroom.repository.RoleRepository;
import com.online.classroom.repository.UserRepository;
import com.online.classroom.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    //creating user
    public User createUser(User user, Set<UserRole> userRoles){
        User local = this.userRepository.findByUserName(user.getUserName());
        if(local != null){
            logger.error("User is already present");
            return null;
        } else{
            for(UserRole userRole : userRoles){
                this.roleRepository.save(userRole.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }

        return local;
    }

    @Override
    public User getUserByUserName(String username) {

        User user = this.userRepository.findByUserName(username);
        logger.info("Got user with username "+ user);
        return user;
    }

    @Override
    public void deleteUser(Long userid) {

        this.userRepository.deleteById(userid);
        logger.info("User deleted with userd "+userid);
    }

    @Override
    public User upsertUser(Long id, User user) {
        Optional<User> local = this.userRepository.findById(id);
        if (local.isEmpty()){
            logger.error("User not present");
            return null;
        }
        User localUser = local.get();
        localUser.setId(user.getId());
        localUser.setUserName(user.getUserName());
        localUser.setFirstName(user.getFirstName());
        localUser.setLastName(user.getLastName());
        localUser.setEmail(user.getPassword());
        localUser.setPhone(user.getPhone());
        localUser.setProfile(user.getProfile());
        localUser.setUserRoles(user.getUserRoles());
        localUser.setEnabled(user.getEnabled());
        User saveUser = this.userRepository.save(localUser);
        logger.info("User got saved with uid "+id + " data "+saveUser);
        return saveUser;
    }


}
