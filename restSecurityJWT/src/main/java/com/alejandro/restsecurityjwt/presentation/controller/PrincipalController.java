package com.alejandro.restsecurityjwt.presentation.controller;


import com.alejandro.restsecurityjwt.persistence.entity.RoleEntity;
import com.alejandro.restsecurityjwt.persistence.entity.UserEntity;
import com.alejandro.restsecurityjwt.persistence.entity.enums.ERole;
import com.alejandro.restsecurityjwt.persistence.repository.UserRepository;
import com.alejandro.restsecurityjwt.presentation.dto.CreateUserRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class PrincipalController {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/hola")
    public String hola(){
        return "Hola mundo sin seguridad";
    }


    @GetMapping("/holaseguro")
    public String holaSeguro(){
        return "Hola mundo con seguridad";
    }

    @PostMapping("/createuser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequestDTO createUserRequestDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Set<RoleEntity> roles = createUserRequestDTO.getRoles().stream()
                .map(r -> RoleEntity.builder()
                        .role(ERole.valueOf(r)).build()).collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserRequestDTO.getUsername())
                .password(passwordEncoder.encode(createUserRequestDTO.getPassword()))
                .email(createUserRequestDTO.getEmail())
                .roles(roles)
                .build();
        userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity<String> deleteUser(@RequestParam("id") Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok("Usuario eliminado");
    }
}
