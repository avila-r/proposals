package com.avila.quotations.service;

import com.avila.quotations.client.CurrencyClient;
import com.avila.quotations.dto.CurrencyPriceResponse;
import com.avila.quotations.entity.Quotation;
import com.avila.quotations.model.CurrencyPair;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.util.Date;

@ApplicationScoped
public class QuotationService {

    @Inject
    @RestClient
    CurrencyClient client;

    public void getCurrencyPrice() {
        CurrencyPriceResponse response = client.getPriceByPair (
                CurrencyPair.USD_BRL.toString()
        );

        boolean ok = update(response);
        if (ok) {

        }
    }

    private boolean update(CurrencyPriceResponse response) {
        BigDecimal current = new BigDecimal(response.getData().getBid());

        return Quotation.findAll()
                .list()
                .stream()
                .map(entity -> (Quotation) entity)
                .reduce((first, second) -> second)
                .map(last -> {
                    if (current.compareTo(last.getPrice()) > 0) {
                        save(response);
                        return true;
                    }
                    return false;
                })
                .orElseGet(() -> {
                    save(response);
                    return true;
                });
    }


    public void save(CurrencyPriceResponse response) {
        Quotation.builder()
                .date(new Date())
                .price(new BigDecimal(response.getData().getBid()))
                .pctChange(response.getData().getPctChange())
                .pair(CurrencyPair.USD_BRL.toString())
                .build()
                .persist();
    }

}
