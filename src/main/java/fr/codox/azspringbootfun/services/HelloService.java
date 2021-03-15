package fr.codox.azspringbootfun.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import fr.codox.azspringbootfun.repositories.HelloRepository;

@Service
public class HelloService {

    private final HelloRepository helloRepository;

    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public String hello(String name, String ip) {
        final var now = LocalDateTime.now();
        helloRepository.addVisitor(ip, now);
        return new StringBuilder("Hello ")
                .append(name)
                .append(", it's ")
                .append(now)
                .toString();
    }
}
