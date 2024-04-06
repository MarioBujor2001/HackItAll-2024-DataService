package com.hackitall.dataservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Float consumption = 0.0f;
    private Boolean status = false;
    @ManyToOne
    @JoinColumn(name = "space_id")
    @JsonIgnore
    private Space space;
}
