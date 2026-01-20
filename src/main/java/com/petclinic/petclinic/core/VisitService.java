package com.petclinic.petclinic.core;

import com.petclinic.petclinic.tech.MyCustomAnnotation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    @MyCustomAnnotation
    public Visit findByReferenceNumber(String referenceNumber) {
        return visitRepository.findByReferenceNumber(referenceNumber).orElseThrow(() -> new RuntimeException("Visit not found"));
    }

}
