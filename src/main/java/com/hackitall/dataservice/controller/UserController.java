package com.hackitall.dataservice.controller;

import com.hackitall.dataservice.entity.Device;
import com.hackitall.dataservice.entity.Space;
import com.hackitall.dataservice.entity.User;
import com.hackitall.dataservice.service.SpaceService;
import com.hackitall.dataservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    SpaceService spaceService;
    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email){
        try{
            User user = userService.findByEmail(email);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{email}/spaces")
    public ResponseEntity<Space> addSpaceToUser(@PathVariable String email,
                                                @RequestBody Space space){
        try{
            User user = userService.findByEmail(email);
            return ResponseEntity.ok(userService.addSpaceToUser(user, space));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{email}/{spaceName}")
    public ResponseEntity<Device> addDeviceToSpace(@PathVariable("email") String email,
                                                   @PathVariable("spaceName") String spaceName,
                                                   @RequestBody Device device){
        try{
            User user = userService.findByEmail(email);
            Space space = spaceService.findByNameAndUser(spaceName, user);
            return ResponseEntity.ok(spaceService.addDeviceToSpace(space, device));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
