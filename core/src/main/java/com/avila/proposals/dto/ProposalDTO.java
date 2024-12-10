package com.avila.proposals.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter @Setter
@Builder
@Jacksonized
public class ProposalDTO {

    private Long id;

    private String customer;

    private BigDecimal price;

}
