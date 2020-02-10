package com.jaydot2.fitnesspro.server.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Builder
@Data
public class AthleteDomain {

    private final Long athleteId;
    private String firstName;
    private String middleName;
    private String lastName;
}
