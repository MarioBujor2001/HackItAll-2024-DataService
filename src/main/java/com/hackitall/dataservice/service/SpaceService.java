package com.hackitall.dataservice.service;

import com.hackitall.dataservice.entity.Device;
import com.hackitall.dataservice.entity.Space;
import com.hackitall.dataservice.entity.User;
import com.hackitall.dataservice.repository.DeviceRepository;
import com.hackitall.dataservice.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceService {
    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    DeviceRepository deviceRepository;

    public Space findByNameAndUser(String spaceName, User user) throws Exception {
        Space space = spaceRepository.findByNameAndUser(spaceName, user);
        if(space == null){
            throw new Exception("Space not found!");
        }
        return space;
    }

    public Device addDeviceToSpace(Space space, Device device) {
        device.setSpace(space);
        deviceRepository.save(device);
        return device;
    }
}
