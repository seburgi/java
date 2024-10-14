package com.hackathon.truckagent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TruckAgentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void singleCargoFromJsonShouldResultInDeliverResponse() throws Exception {
        var jsonContent = new String(DeserializationTests.class.getResourceAsStream("/sample_decide_0.json").readAllBytes());

        this.mockMvc.perform(
                        post("/decide").contentType(MediaType.APPLICATION_JSON).content(jsonContent))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.command").value("DELIVER"))
                .andExpect(jsonPath("$.argument").value(100));
    }
}
