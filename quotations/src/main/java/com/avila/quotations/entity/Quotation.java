package com.avila.quotations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@NoArgsConstructor @AllArgsConstructor
@Builder @Getter @Setter

@Table(name = "t_quotation")
@Entity public class Quotation extends PanacheEntity {
    private Date date;

    @Column(name = "currency_price")
    private BigDecimal price;

    @Column(name = "pct_change")
    private String pctChange;

    private String pair;
}
