package com.avila.quotations.client;

import com.avila.quotations.dto.CurrencyPriceResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/last")
@RegisterRestClient
@ApplicationScoped
public interface CurrencyClient {
    @Path("/{pair}")
    @GET CurrencyPriceResponse getPriceByPair(@PathParam("pair") String pair);
}
