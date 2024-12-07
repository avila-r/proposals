package com.avila.quotations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
@NoArgsConstructor
@Builder @Jacksonized
@Getter @Setter
public class CurrencyPriceResponse {
    private CurrencyPairResponse data;
}
