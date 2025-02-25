package com.example.projet_service.controllers;

import com.example.projet_service.entities.Projet;
import com.example.projet_service.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/projets")
public class ProjetController {
   @Autowired
    private ProjetRepository projetRepository;

    @GetMapping
    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }


    // GET /projets/{id} - Get a single project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        Optional<Projet> projetOptional = projetRepository.findById(id);
        return projetOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Projet createProjet(@RequestBody Projet projet) {
        return projetRepository.save(projet);
    }


    // PUT /projets/{id} - Update an existing project
    @PutMapping("/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable Long id, @RequestBody Projet projetDetails) {
        Optional<Projet> projetOptional = projetRepository.findById(id);
        if (projetOptional.isPresent()) {
            Projet projet = projetOptional.get();
            projet.setName(projetDetails.getName());
            projet.setDescription(projetDetails.getDescription());
            Projet updatedProjet = projetRepository.save(projet);
            return ResponseEntity.ok(updatedProjet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // DELETE /projets/{id} - Delete a project
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        Optional<Projet> projetOptional = projetRepository.findById(id);
        if (projetOptional.isPresent()) {
            projetRepository.delete(projetOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}