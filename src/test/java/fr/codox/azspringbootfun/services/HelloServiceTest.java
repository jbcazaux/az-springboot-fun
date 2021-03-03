package fr.codox.azspringbootfun.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

    @Test
    public void hello() {
        HelloService hs = new HelloService();

        assertThat(hs.hello("something")).isEqualTo("Hello something !");
    }
}