package org.example.beneficiaireservice;

import org.example.beneficiaireservice.entities.Beneficiary;
import org.example.beneficiaireservice.reopsitory.BeneficiaryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeneficiaireServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeneficiaireServiceApplication.class, args);
    }
  /*  @Bean
    CommandLineRunner start(BeneficiaryRepository repository) {
        return args -> {
            repository.save(new Beneficiary(null, "Nouhaila", "Nouhaila", "FR761234598765", Beneficiary.Type.PHYSIQUE));
            repository.save(new Beneficiary(null, "Aamal", "Alae", "FR001122334455", Beneficiary.Type.MORALE));
            repository.save(new Beneficiary(null, "Saad", "Saad", "FR0011223347838", Beneficiary.Type.MORALE));
            repository.findAll().forEach(System.out::println);
        };
    }*/
}