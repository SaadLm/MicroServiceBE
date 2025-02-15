package com.example.projet_service.repositories;

import com.example.projet_service.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Long> {}