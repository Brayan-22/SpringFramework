package com.alejandro.restsecurityjwt;

import com.alejandro.restsecurityjwt.persistence.entity.RoleEntity;
import com.alejandro.restsecurityjwt.persistence.entity.UserEntity;
import com.alejandro.restsecurityjwt.persistence.entity.enums.ERole;
import com.alejandro.restsecurityjwt.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class RestSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestSecurityJwtApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.save(UserEntity.builder().username("alejandro")
                    .email("alejandro@gmail.com")
                            .password(new BCryptPasswordEncoder().encode("alejandro123"))
                            .roles(Set.of(RoleEntity.builder().role(ERole.ADMIN).build()))
                    .build());
        };
    }

}
