package com.petclinic.petclinic.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreetingServiceTest {

    @Test
    void shouldGreetSuccessfully() {
        GreetingService greetingService = new GreetingService();
        String result = greetingService.sayHi("World");
        Assertions.assertThat(result).isEqualTo("Hello, World!");
    }
}
