package com.avila.proposals.service;

import com.avila.proposals.dto.ProposalDTO;
import com.avila.proposals.dto.ProposalDetails;
import com.avila.proposals.entity.Proposal;
import com.avila.proposals.messaging.KafkaProducer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProposalService {

    @Inject
    KafkaProducer producer;

    public ProposalDetails find(Long id) {
        Proposal proposal = Proposal.findById(id);

        return ProposalDetails.builder()
                .id(proposal.id)
                .customer(proposal.getCustomer())
                .price(proposal.getPrice())
                .deadline(proposal.getDeadline())
                .country(proposal.getCountry())
                .tonnes(proposal.getTonnes())
                .build();
    }

    @Transactional
    public ProposalDTO save(ProposalDetails request) {
        Proposal proposal = Proposal.builder()
                .customer(request.getCustomer())
                .price(request.getPrice())
                .deadline(request.getDeadline())
                .country(request.getCountry())
                .tonnes(request.getTonnes())
                .build();

        proposal.persist();

        return ProposalDTO.builder()
                .id(proposal.id)
                .customer(proposal.getCustomer())
                .price(proposal.getPrice())
                .build();
    }

    @Transactional
    public boolean delete(Long id) {
        return Proposal.deleteById(id);
    }

}
