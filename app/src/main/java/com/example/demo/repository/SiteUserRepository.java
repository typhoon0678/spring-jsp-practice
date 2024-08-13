package com.example.demo.repository;

import com.example.demo.entity.SiteUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SiteUserRepository extends CrudRepository<SiteUser, Long> {

    Optional<SiteUser> findByUsername(String username);
    Optional<SiteUser> findByEmail(String email);
}
