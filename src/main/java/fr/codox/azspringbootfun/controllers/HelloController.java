package fr.codox.azspringbootfun.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import fr.codox.azspringbootfun.configurations.MessageProperties;
import fr.codox.azspringbootfun.services.HelloService;

@RestController
public class HelloController {

    private final HelloService helloService;
    private final MessageProperties messageProperties;

    public HelloController(HelloService helloService, MessageProperties messageProperties) {
        this.helloService = helloService;
        this.messageProperties = messageProperties;
    }

    @GetMapping
    public String hello(@RequestHeader(name = "X-Forwarded-For", required = false) String ip) {
        return helloService.hello("world", Optional.ofNullable(ip).orElse("unknown"));
    }

    @GetMapping("/message")
    public String message() {
        return messageProperties.getMessage();
    }
    @GetMapping("toto")
    public String message2() {
        return messageProperties.getMessage();
    }
}
