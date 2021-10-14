package com.hla.test.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class NameControllerTest {
    private static final Logger LOG = LoggerFactory.getLogger(NameControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRandomName() throws Exception {
        String name = mockMvc.perform(MockMvcRequestBuilders.get("/name/random")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        LOG.info("Generated name: '{}'", name);

        Assertions.assertNotNull(name);
        String[] nameComponents = name.split(" ");
        Assertions.assertEquals(2, nameComponents.length);
    }
}