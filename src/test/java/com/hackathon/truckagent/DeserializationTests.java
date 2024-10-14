package com.hackathon.truckagent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.truckagent.model.DecideRequest;
import com.hackathon.truckagent.model.Location;
import org.json.JSONException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;
import java.util.List;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@JsonTest
public class DeserializationTests {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testDecideRequest() throws IOException, JSONException {
        var jsonContent = new String(DeserializationTests.class.getResourceAsStream("/sample_decide_0.json").readAllBytes());
        var decideRequest = objectMapper.readValue(jsonContent, DecideRequest.class);

        assertEquals(jsonContent, objectMapper.writeValueAsString(decideRequest), JSONCompareMode.STRICT);
    }

    @Test
    @Disabled(value = "Download map.json from https://github.com/WALTER-GROUP/hackathon-sustainable-logistics/blob/main/data/map.json first")
    public void testWorldInfo() throws IOException, JSONException {
        // The world map can be downloaded by a truck agent from https://github.com/WALTER-GROUP/hackathon-sustainable-logistics/blob/main/data/map.json during a simulation run.
        // It is not required to download it, but a team might be able to get some useful  information from the map to optimize their truck agents decisions.
        // To make individual decide requests as fast as possible, it is better to download the map at the very beginning, when the agent starts up,
        // otherwise the simulation might decide that the truck is reacting too slow and exclude it from the current simulation run.

        var jsonContent = new String(DeserializationTests.class.getResourceAsStream("/map.json").readAllBytes());
        var decideRequest = objectMapper.readValue(jsonContent, new TypeReference<List<Location>>() { });

        assertEquals(jsonContent, objectMapper.writeValueAsString(decideRequest), JSONCompareMode.STRICT);
    }
}
