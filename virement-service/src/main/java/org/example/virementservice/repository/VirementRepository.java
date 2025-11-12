package org.example.virementservice.repository;

import org.example.virementservice.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VirementRepository extends JpaRepository<Virement, Long> {
    List<Virement> findByBeneficiaryId(Long beneficiaryId);
}