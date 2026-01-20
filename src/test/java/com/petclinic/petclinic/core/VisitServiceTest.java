package com.petclinic.petclinic.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Test
    void shouldFindByReferenceNumber() {

        log.debug("It Should not be seen depending on the log level configuration");
        String referenceNumber = "Ref";
        var result = visitService.findByReferenceNumber(referenceNumber);
        assertThat(result).usingRecursiveComparison().ignoringFields("date").isEqualTo(Visit.staticVisitStub);
    }
}
