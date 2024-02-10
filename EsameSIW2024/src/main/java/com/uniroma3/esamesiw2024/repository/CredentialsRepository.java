package com.uniroma3.esamesiw2024.repository;

import com.uniroma3.esamesiw2024.entity.Credentials;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CredentialsRepository extends CrudRepository<Credentials,Long> {

    public Optional<Credentials> findByUsername(String username);

}
