package com.jg.book.auth;

import org.springframework.stereotype.Service;

import com.jg.book.role.Role;
import com.jg.book.role.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private RoleRepository roleRepository;

    public void register(RegistrationRequest request) {
        var userRole
    }
}
