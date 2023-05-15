package com.foodwastage.backend.auth;


import com.foodwastage.backend.config.JwtService;
import com.foodwastage.backend.model.Role;
import com.foodwastage.backend.model.User;
import com.foodwastage.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(request.getAddress())
                .branComName(request.getBranComName())
                .role(Role.COLLECTOR)
                .build();
        if(!repository.existsByEmail(request.getEmail())){
            repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }
        else{
            return AuthenticationResponse.builder()
                    .Error("User already exits")
                    .build();
        }

    }

    public User findByEmail(String email) {
        Optional<User> user = repository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        throw new RuntimeException("Community not found in " + email);
    }
}
