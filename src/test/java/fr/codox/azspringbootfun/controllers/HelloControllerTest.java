package fr.codox.azspringbootfun.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import fr.codox.azspringbootfun.services.HelloService;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
class HelloControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @Test
    public void getHello() throws Exception {
        Mockito.when(helloService.hello("world")).thenReturn("foo");

        mockMvc.perform(MockMvcRequestBuilders.get("/").accept(TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("foo")));
    }
}