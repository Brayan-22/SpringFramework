package com.alejandro.restsecurityjwt.services;

import com.alejandro.restsecurityjwt.persistence.entity.UserEntity;
import com.alejandro.restsecurityjwt.persistence.entity.enums.ERole;
import com.alejandro.restsecurityjwt.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository
                .findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("El usuario "+username+" no existe"));
        Collection<? extends GrantedAuthority> authorities = user.getRoles().stream().map(r -> new SimpleGrantedAuthority("ROLE_".concat(r.getRole().name()))).collect(Collectors.toSet());
        return new User(user.getUsername(),user.getPassword(),true,true,true,true,authorities);
    }
}
