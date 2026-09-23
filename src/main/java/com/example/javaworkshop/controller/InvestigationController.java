package com.example.javaworkshop.controller;

import com.example.javaworkshop.model.Investigation;
import com.example.javaworkshop.service.InvestigationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investigations")
@Tag(name = "Investigations", description = "API for managing investigations")
public class InvestigationController {

    private final InvestigationService investigationService;

    public InvestigationController(InvestigationService investigationService) {
        this.investigationService = investigationService;
    }

    @GetMapping
    @Operation(summary = "Get all investigations", description = "Retrieve a list of all investigations")
    public List<Investigation> getAllInvestigations() {
        return investigationService.getAllInvestigations();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get investigation by ID", description = "Retrieve a specific investigation by its ID")
    public Investigation getInvestigationById(
            @Parameter(description = "ID of the investigation to retrieve") @PathVariable Long id) {
        return investigationService.getInvestigationById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new investigation", description = "Create a new investigation for a transaction")
    public Investigation createInvestigation(
            @Parameter(description = "ID of the transaction to investigate") @RequestParam Long transactionId,
            @Parameter(description = "Reason for the investigation") @RequestParam String reason) {

        if (transactionId == null || reason == null || reason.isEmpty()) {
            throw new IllegalArgumentException("Transaction ID and reason must not be null or empty.");
        }

        return investigationService.createInvestigation(transactionId, reason);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update an investigation", description = "Update the status or reason of an investigation")
    public Investigation updateInvestigation(
            @Parameter(description = "ID of the investigation to update") @PathVariable Long id,
            @Parameter(description = "New status of the investigation") @RequestParam(required = false) String status,
            @Parameter(description = "New reason for the investigation") @RequestParam(required = false) String reason) {

        return investigationService.updateInvestigation(
                id,
                status,
                reason
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an investigation", description = "Delete an investigation by its ID")
    public void deleteInvestigation(@Parameter(description = "ID of the investigation to delete") @PathVariable Long id) {
        investigationService.deleteInvestigation(id);
    }
}