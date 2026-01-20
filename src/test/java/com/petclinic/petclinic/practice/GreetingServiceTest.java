package com.petclinic.petclinic.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatList;

@SpringBootTest(classes = {GreetingService.class})
@Slf4j
public class GreetingServiceTest {

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GreetingService.class);
    @Autowired
    private GreetingService greetingService;

    @Test
    void shouldGreetSuccessfully() {
        GreetingService greetingService = new GreetingService();
        String result = greetingService.sayHi("World");
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    void shouldGreetSuccessfullyWithContext() {
//        GreetingService greetingService = context.getBean(GreetingService.class);
        String result = greetingService.sayHi("World");
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    void shouldCountBeanDefinitions() {
        var beanNumber = context.getBeanDefinitionCount();
        assertThat(beanNumber).isGreaterThanOrEqualTo(1);
    }

    @Test
    void shouldDisplayBeanDefinitions() {
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            log.info(beanName);
        }
        assertThatList(Arrays.stream(beanNames).map(String::toLowerCase).toList()).contains(GreetingService.class.getSimpleName().toLowerCase());
    }
}
