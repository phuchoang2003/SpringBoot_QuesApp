package com.example.demo.Controller;

import com.example.demo.DTO.AuthenticationRequestDTO;
import com.example.demo.DTO.AuthenticationResponseDTO;
import com.example.demo.Service.AuthenticationService;
import com.example.demo.DTO.RegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authentication(@RequestBody AuthenticationRequestDTO request){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
