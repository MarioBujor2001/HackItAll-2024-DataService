package com.hackitall.dataservice.cache;

import com.hackitall.dataservice.entity.EnergyEvent;
import com.hackitall.dataservice.service.EnergyEventService;
import com.hackitall.dataservice.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
@EnableScheduling
public class EventsCache {
    @Autowired
    EnergyEventService eventService;
    static Logger LOG = LoggerFactory.getLogger(EventsCache.class);
    private static Collection<String> cache = Collections.synchronizedCollection(new ArrayList<String>());
    public static void add(String object){
        cache.add(object);
        LOG.info("Added to cache :{}", object);
    }
    public static List<EnergyEvent> getCache(){
        return new ArrayList<>(JsonUtil.stringListToObjectList(cache));
    }
    @Scheduled(fixedRate = 60000)
    private void evictCache(){
        eventService.saveAll(cache);
        cache.clear();
        LOG.info("Cache evicted!");
    }
}
