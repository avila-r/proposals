package com.avila.proposals.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Builder @Getter @Setter

@Table(name = "t_proposal")
@Entity public class Proposal extends PanacheEntity {

    @Column(name = "customer", nullable = false)
    @NotBlank
    private String customer;

    @Column(name = "price_tonne", nullable = false)
    private BigDecimal price;

    @Column(name = "tonnes", nullable = false)
    private Integer tonnes;

    @Column(name = "country", nullable = false)
    @NotBlank
    private String country;

    @Column(name = "deadline", nullable = false)
    private Integer deadline;

    private Date created;
}
