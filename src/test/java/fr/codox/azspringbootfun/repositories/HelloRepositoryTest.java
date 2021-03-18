package fr.codox.azspringbootfun.repositories;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class HelloRepositoryTest {

    @Autowired
    private HelloRepository helloRepository;

    @Test
    public void get() {
        helloRepository.addVisitor("test ip", LocalDateTime.of(1980, 9, 28, 0, 0));

        var result = helloRepository.findAllIps();

        Assertions.assertThat(result).hasSizeGreaterThan(0);
    }
}