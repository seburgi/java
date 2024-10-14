package com.hackathon.truckagent.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CargoOffer {
    private int uid;
    private String name;
    private String origin;
    private String dest;
    private double price;

    @JsonProperty("eta_to_cargo")
    private double etaToCargo;

    @JsonProperty("km_to_cargo")
    private double kmToCargo;

    @JsonProperty("eta_to_deliver")
    private double etaToDeliver;

    @JsonProperty("km_to_deliver")
    private double kmToDeliver;
}
