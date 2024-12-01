package com.example.springsecuritydemo.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//SecurityFilterChain :
//Il est défini comme un bean pour configurer les règles de sécurité.
//        => Utilise HttpSecurity : pour spécifier les règles (exemple : accès autorisé, authentification).
// PasswordEncoder: est essentiel pour encoder les mots de passe avant de les stocker dans la base de données.

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())  // Désactive la protection CSRF pour simplifier les tests

                .authorizeHttpRequests( auth -> auth
                        .requestMatchers("/public/**").permitAll()  // Permet l'accès sans authentification à certains chemins
                        .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification

                )

                .formLogin(form -> form.defaultSuccessUrl("/home", true)) // Active le formulaire de connexion par défaut
                .httpBasic(basic -> {});

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // Encodeur de mot de passe sécurisé avec bytcode
    }





}

