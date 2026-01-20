package com.petclinic.petclinic.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class VisitServiceUnitTest {

    @Mock
    private VisitRepository visitRepository;
    @InjectMocks
    private VisitService visitService;

    @Test
    void shouldFindVisitByReferenceNumber() {
        Mockito.when(visitRepository.findByReferenceNumber(ArgumentMatchers.anyString())).thenReturn(Optional.of(Visit.staticVisitStub));
        var result = visitService.findByReferenceNumber("Ref");
        Assertions.assertThat(result.getId()).isEqualTo(Visit.staticVisitStub.getId());
        Mockito.verify(visitRepository, Mockito.times(1)).findByReferenceNumber("Ref");
    }

    @Test
    void shouldThrowWhenVisitNotFound() {
        Mockito.when(visitRepository.findByReferenceNumber(ArgumentMatchers.anyString())).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> visitService.findByReferenceNumber("UnknownRef"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Visit not found");
        Mockito.verify(visitRepository, Mockito.times(1)).findByReferenceNumber("UnknownRef");
    }
}
