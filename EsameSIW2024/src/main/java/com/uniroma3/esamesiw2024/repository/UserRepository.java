package com.uniroma3.esamesiw2024.repository;

import com.uniroma3.esamesiw2024.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
