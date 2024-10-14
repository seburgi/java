package com.hackathon.truckagent.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TruckState {
    private int uid;
    private double balance;
    private String loc;
    @JsonProperty("hours_since_full_rest")
    private double hoursSinceFullRest;
    private double time;
}
