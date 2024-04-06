package com.hackitall.dataservice.service;

import com.hackitall.dataservice.entity.Space;
import com.hackitall.dataservice.entity.User;
import com.hackitall.dataservice.repository.SpaceRepository;
import com.hackitall.dataservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SpaceRepository spaceRepository;

    public User findByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new Exception("User not found!");
        }
        return user;
    }

    public Space addSpaceToUser(User user, Space space){
        space.setUser(user);
        spaceRepository.save(space);
        return space;
    }
}
