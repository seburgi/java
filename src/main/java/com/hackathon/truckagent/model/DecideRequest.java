package com.hackathon.truckagent.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DecideRequest {
    private TruckState truck;
    private List<CargoOffer> offers = List.of();
    @JsonProperty("is_fleet")
    private boolean isFleet;
}
