package com.hackitall.dataservice.repository;

import com.hackitall.dataservice.entity.Space;
import com.hackitall.dataservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Integer> {
    Space findByNameAndUser(String name, User user);
}
