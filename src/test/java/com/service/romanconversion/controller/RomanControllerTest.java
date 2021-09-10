package com.service.romanconversion.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/*
  Test Driven Development approach
   - This class 1) does Smoke tests (endpoints) test of the Roman numeral Conversion service
                2) validates the query params required criteria

*/

@SpringBootTest
@AutoConfigureMockMvc
public class RomanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String requestString = "/romannumeral?query=";

    @Test
    void test_RomanMaxValidationException() throws Exception {
        this.mockMvc.perform(get(requestString+"256"))
                    .andExpect(status().isBadRequest());
    }

    @Test
    void test_RomanMinValidationException() throws Exception {
        this.mockMvc.perform(get(requestString + "0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test_RomanSuccessValidation_1() throws Exception {
        this.mockMvc.perform(get(requestString+"1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("I")));
    }


}
