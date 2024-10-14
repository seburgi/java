package com.hackathon.truckagent.model;

import lombok.Getter;
import lombok.Setter;

// The world map can be downloaded by a truck agent from https://github.com/WALTER-GROUP/hackathon-sustainable-logistics/blob/main/data/map.json during a simulation run.
// It is not required to download it, but a team might be able to get some useful  information from the map to optimize their truck agents decisions.
// To make individual decide requests as fast as possible, it is better to download the map at the very beginning, when the agent starts up,
// otherwise the simulation might decide that the truck is reacting too slow and exclude it from the current simulation run.

@Getter
@Setter
public class Road {
    private String dest;
    private double km;
    private double kmh;
    private boolean major;
}
