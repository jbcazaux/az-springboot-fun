package fr.codox.azspringbootfun.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.codox.azspringbootfun.repositories.HelloRepository;

@ExtendWith(MockitoExtension.class)
class HelloServiceTest {

    @Mock
    private HelloRepository helloRepository;

    @InjectMocks
    private HelloService helloService;

    @Test
    public void hello() {
        final var hello = helloService.hello("name", "ip");

        assertThat(hello).startsWith("Hello name, it's ");
        verify(helloRepository).addVisitor(eq("ip"), any(LocalDateTime.class));
    }
}