package com.example.javaworkshop.repository;

import com.example.javaworkshop.model.Investigation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvestigationRepository {

    private final List<Investigation> investigations = new ArrayList<>();

    private Long nextId = 1L;

    public List<Investigation> findAll() {
        return investigations;
    }

    public Investigation findById(Long id) {
        return investigations.stream()
                .filter(investigation -> investigation.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Investigation save(Investigation investigation) {
        investigations.add(investigation);
        return investigation;
    }

    public void delete(Long id) {
        investigations.removeIf(
                investigation -> investigation.getId().equals(id)
        );
    }

    public Investigation create(Long transactionId, String reason) {
        Investigation investigation = new Investigation(nextId++, transactionId, reason, "NEW");
        investigations.add(investigation);
        return investigation;
    }
}