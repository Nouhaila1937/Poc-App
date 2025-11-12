package org.example.virementservice.web;
import org.example.virementservice.entities.Virement;
import org.example.virementservice.feign.BeneficiaryClient;
import org.example.virementservice.repository.VirementRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/virements")
@CrossOrigin("*")
public class VirementRestController {

    private final VirementRepository repository;
    private final BeneficiaryClient beneficiaryClient;

    public VirementRestController(VirementRepository repository, BeneficiaryClient beneficiaryClient1) {
        this.repository = repository;
        this.beneficiaryClient = beneficiaryClient1;
    }

    @GetMapping
    public List<Virement> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Virement> getOne(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/byBeneficiary/{beneficiaryId}")
    public List<Virement> byBeneficiary(@PathVariable Long beneficiaryId) {
        return repository.findByBeneficiaryId(beneficiaryId);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Virement v) {
        // Validate beneficiary exists (via Feign)
        try {
            var b = beneficiaryClient.getById(v.getBeneficiaryId());
            if (b == null || b.getId() == null) {
                return ResponseEntity.badRequest().body("Beneficiary not found");
            }
            Virement saved = repository.save(v);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de la validation du bénéficiaire: " + e.getMessage());
        }
    }
}