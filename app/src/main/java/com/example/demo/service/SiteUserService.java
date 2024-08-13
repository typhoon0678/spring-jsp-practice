package com.example.demo.service;

import com.example.demo.entity.SiteUser;
import com.example.demo.form.UserRegisterForm;
import com.example.demo.repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SiteUserService {

    private final PasswordEncoder passwordEncoder;
    private final SiteUserRepository siteUserRepository;

    public void addUser(UserRegisterForm form) {
        Optional<SiteUser> optional = siteUserRepository
                .findByUsername(form.getUsername());
        if (optional.isPresent()) {
            throw new RuntimeException("Already in Use");
        }

        optional = siteUserRepository.findByEmail(form.getEmail());
        if (optional.isPresent()) {
            throw new RuntimeException("Already in Use");
        }

        String password = passwordEncoder.encode(form.getPassword());

        SiteUser siteUser = new SiteUser();
        siteUser.setUsername(form.getUsername());
        siteUser.setPassword(password);
        siteUser.setNickname(form.getNickname());
        siteUser.setEmail(form.getEmail());

        siteUserRepository.save(siteUser);
    }
}
