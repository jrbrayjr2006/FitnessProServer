package com.jaydot2.fitnesspro.server.domain;

import lombok.Builder;

import javax.persistence.Entity;

@Entity
@Builder
public class AthleteDomain {

    private final Long athleteId;
    private String firstName;
    private String middleName;
    private String lastName;
}
