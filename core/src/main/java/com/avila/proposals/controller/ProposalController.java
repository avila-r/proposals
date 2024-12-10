package com.avila.proposals.controller;

import com.avila.proposals.dto.ProposalDetails;
import com.avila.proposals.service.ProposalService;

import io.quarkus.security.Authenticated;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/proposals")
@Authenticated
public class ProposalController {

    @Inject
    JsonWebToken token;

    @Inject
    ProposalService service;

    @GET
    @Path("/{id}")
    @RolesAllowed({"user", "admin"})
    public ProposalDetails get(@PathParam("id") Long id) {
        return service.find(id);
    }

    @POST
    @RolesAllowed("customer")
    public Response post(ProposalDetails request) {
        return Response.status(Response.Status.CREATED)
                .entity(service.save(request))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("admin")
    public Response delete(@PathParam("id") Long id) {
        return service.delete(id)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

}
