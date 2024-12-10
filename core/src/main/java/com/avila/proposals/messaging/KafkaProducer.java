package com.avila.proposals.messaging;

import com.avila.proposals.dto.ProposalDTO;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class KafkaProducer {

    @Channel("proposal")
    Emitter<ProposalDTO> emitter;

    public void send(ProposalDTO request) {
        emitter.send(request)
                .toCompletableFuture()
                .join();
    }

}
