package com.hackitall.dataservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackitall.dataservice.entity.EnergyEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonUtil {
    public static EnergyEvent stringToJson(String content){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(content, EnergyEvent.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
    public static List<EnergyEvent> stringListToObjectList(Collection<String> contents){
        List<EnergyEvent> list = new ArrayList<>();
        for(String content : contents){
            list.add(stringToJson(content));
        }
        return list;
    }
}
