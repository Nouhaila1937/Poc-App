package org.example.beneficiaireservice.reopsitory;

import org.example.beneficiaireservice.entities.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Optional;

@RepositoryRestResource
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
    Optional<Beneficiary> findByRib(String rib);
}
