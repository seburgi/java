package com.hackathon.truckagent;

import com.hackathon.truckagent.model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TruckAgentController {

    /**
     * See https://app.swaggerhub.com/apis-docs/walter-group/walter-group-hackathon-sustainable-logistics/1.0.0 for 
     * a detailed description of this endpoint.
     */
    @PostMapping("/decide")
    public DecideResponse decide(@RequestBody DecideRequest request) {
        // Always deliver the first cargo available, otherwise sleep until one is available
        if(!request.getOffers().isEmpty()) {
            return DecideResponse.deliver(request.getOffers().get(0).getUid());
        }

        return DecideResponse.sleep(1);
    }
}
