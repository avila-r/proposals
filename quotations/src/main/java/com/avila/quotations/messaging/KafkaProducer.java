package com.avila.quotations.messaging;

import com.avila.quotations.dto.QuotationDTO;

import jakarta.enterprise.context.ApplicationScoped;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Slf4j
@ApplicationScoped
public class KafkaProducer {

    @Channel("quotations")
    Emitter<QuotationDTO> emitter;

    public void send(QuotationDTO quotation) {
        emitter.send(quotation)
                .toCompletableFuture()
                .join();
    }

}
