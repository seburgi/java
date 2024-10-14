package com.hackathon.truckagent.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecideResponse {
    private DecideResponseType command;
    private Object argument;

    private DecideResponse(DecideResponseType command, Object argument) {
        this.command = command;
        this.argument = argument;
    }

    private enum DecideResponseType {
        DELIVER,
        ROUTE,
        SLEEP
    }

    public static DecideResponse deliver(int cargoUid) {
        return new DecideResponse(DecideResponseType.DELIVER, cargoUid);
    }

    public static DecideResponse route(String destinationName) {
        return new DecideResponse(DecideResponseType.ROUTE, destinationName);
    }

    public static DecideResponse sleep(int hours) {
        if (hours < 1) {
            throw new IllegalArgumentException("Sleep needs to be at least 1 hour.");
        }
        return new DecideResponse(DecideResponseType.SLEEP, hours);
    }

}
