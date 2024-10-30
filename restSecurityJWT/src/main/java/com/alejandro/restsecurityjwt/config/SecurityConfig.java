package com.alejandro.restsecurityjwt.config;


import com.alejandro.restsecurityjwt.utils.JwtUtils;
import com.alejandro.restsecurityjwt.utils.filters.JwtAuthenticationFilter;
import com.alejandro.restsecurityjwt.utils.filters.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    private final UserDetailsService userDetailsService;

    private final JwtAuthorizationFilter jwtAuthorizationFilter;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,AuthenticationManager authenticationManager, JwtUtils jwtUtils) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
        return http
                .csrf(c -> c.disable())
                .authorizeHttpRequests(authorizeRequests ->{
                    authorizeRequests.requestMatchers("/api/auth/hola").permitAll();
                    authorizeRequests.anyRequest().authenticated();
                })
                .sessionManagement(sessionManagement ->{
                    sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                //.httpBasic(Customizer.withDefaults())
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
////        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////        manager.createUser(User.withUsername("alejandro").password("alejandro").build());
////        return manager;
//
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }



}
