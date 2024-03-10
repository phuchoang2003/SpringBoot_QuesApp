package com.example.demo.Service;


import com.example.demo.DTO.AuthenticationRequestDTO;
import com.example.demo.DTO.AuthenticationResponseDTO;
import com.example.demo.DTO.RegisterRequestDTO;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponseDTO register(RegisterRequestDTO request){
        var user =User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(User.Role.USER)
                .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponseDTO.builder()
            .token(jwtToken)
            .build();
}

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request){
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );
    var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
