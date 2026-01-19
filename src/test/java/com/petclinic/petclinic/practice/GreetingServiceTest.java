package com.petclinic.petclinic.practice;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatList;

public class GreetingServiceTest {

    //    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.petclinic.petclinic");
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GreetingService.class);

    @Test
    void shouldGreetSuccessfully() {
        GreetingService greetingService = new GreetingService();
        String result = greetingService.sayHi("World");
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    void shouldGreetSuccessfullyWithContext() {
        GreetingService greetingService = context.getBean(GreetingService.class);
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
            System.out.println(beanName);
        }
        assertThatList(Arrays.stream(beanNames).map(String::toLowerCase).toList()).contains(GreetingService.class.getSimpleName().toLowerCase());
    }
}
