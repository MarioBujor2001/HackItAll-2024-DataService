package com.hackitall.dataservice.repository;

import com.hackitall.dataservice.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
