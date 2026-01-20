package com.petclinic.petclinic.core;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class VisitRepository {
    public Optional<Visit> findByReferenceNumber(String referenceNumber) {
        return Optional.of(Visit.staticVisitStub);
    }
}
