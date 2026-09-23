package com.example.javaworkshop.service;

import com.example.javaworkshop.model.Investigation;
import com.example.javaworkshop.repository.InvestigationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigationService {

    private final InvestigationRepository investigationRepository;

    public InvestigationService(InvestigationRepository investigationRepository) {
        this.investigationRepository = investigationRepository;
    }

    public List<Investigation> getAllInvestigations() {
        return investigationRepository.findAll();
    }

    public Investigation getInvestigationById(Long id) {
        return investigationRepository.findById(id);
    }


    public Investigation updateInvestigation(Long id, String status, String reason) {

        Investigation investigation = investigationRepository.findById(id);

        if (investigation == null) {
            return null;
        }

        if (status != null) {
            investigation.setStatus(status);
        }

        if (reason != null) {
            investigation.setReason(reason);
        }

        return investigation;
    }

    public void deleteInvestigation(Long id) {
        investigationRepository.delete(id);
    }

    public Investigation createInvestigation(Long transactionId, String reason) {
        return investigationRepository.create(transactionId, reason);
    }



}