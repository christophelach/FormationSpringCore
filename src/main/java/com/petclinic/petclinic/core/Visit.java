package com.petclinic.petclinic.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Visit {

    public static Visit staticVisitStub = new Visit(1L, "Ref", LocalDate.now(), "Stub");

    private Long id;
    private String referenceNumber;
    private LocalDate date;
    private String purpose;
}
