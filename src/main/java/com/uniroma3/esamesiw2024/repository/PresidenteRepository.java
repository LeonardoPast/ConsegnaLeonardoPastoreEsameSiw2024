package com.uniroma3.esamesiw2024.repository;

import com.uniroma3.esamesiw2024.entity.Presidente;
import com.uniroma3.esamesiw2024.model.PresidenteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresidenteRepository extends JpaRepository<Presidente, Long> {

    public Presidente findByNome(String nome);
}
