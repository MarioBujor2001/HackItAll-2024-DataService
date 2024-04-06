package com.hackitall.dataservice.service;

import com.hackitall.dataservice.entity.EnergyEvent;
import com.hackitall.dataservice.repository.EnergyEventRepository;
import com.hackitall.dataservice.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EnergyEventService {
    @Autowired
    EnergyEventRepository energyEventRepository;

    public List<EnergyEvent> saveAll(Collection<String> events){
        List<EnergyEvent> energyEvents = events.stream().map(JsonUtil::stringToJson).toList();
        return energyEventRepository.saveAll(energyEvents);
    }
}
