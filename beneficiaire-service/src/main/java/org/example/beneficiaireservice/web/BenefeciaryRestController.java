package org.example.beneficiaireservice.web;

import org.example.beneficiaireservice.entities.Beneficiary;
import org.example.beneficiaireservice.reopsitory.BeneficiaryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaries")
@CrossOrigin("*")
public class BenefeciaryRestController  {
    private final BeneficiaryRepository repository;

    public BenefeciaryRestController(BeneficiaryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Beneficiary> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiary> getOne(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Beneficiary create(@RequestBody Beneficiary b) {
        return repository.save(b);
    }

    @GetMapping("/byRib")
    public ResponseEntity<Beneficiary> getByRib(@RequestParam String rib) {
        return repository.findByRib(rib).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}