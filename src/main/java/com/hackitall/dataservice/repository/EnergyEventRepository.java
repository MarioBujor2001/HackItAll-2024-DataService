package com.hackitall.dataservice.repository;

import com.hackitall.dataservice.entity.EnergyEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyEventRepository extends JpaRepository<EnergyEvent, Integer> {
}
