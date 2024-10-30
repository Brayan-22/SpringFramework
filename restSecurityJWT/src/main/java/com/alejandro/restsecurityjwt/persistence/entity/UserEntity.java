package com.alejandro.restsecurityjwt.persistence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank
    @Size(max = 80)
    private String email;
    @NotBlank
    @Size(max = 80)
    private String username;
    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,targetEntity = RoleEntity.class,cascade = CascadeType.PERSIST)
    @JoinTable(
          name = "user_role",
          joinColumns = @JoinColumn(name = "idUser"),
          inverseJoinColumns = @JoinColumn(name = "idRole")
    )
    private Set<RoleEntity> roles = new HashSet<>();
}
