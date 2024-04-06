package com.hackitall.dataservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackitall.dataservice.entity.EnergyEvent;
import com.hackitall.dataservice.repository.EnergyEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EnergyEventService {
    @Autowired
    EnergyEventRepository energyEventRepository;

    public List<EnergyEvent> saveAll(Collection<String> events){
        List<EnergyEvent> energyEvents = events.stream().map(this::stringToJson).toList();
        return energyEventRepository.saveAll(energyEvents);
    }

    private EnergyEvent stringToJson(String event) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(event, EnergyEvent.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
