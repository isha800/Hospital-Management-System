package com.Hospital.Management.System.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .cors(Customizer.withDefaults()) 
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/api/user/**",      
	                    "/api/patients/**", 
	                    "/api/doctors/**",
	                    "/api/dashboard/**",
	                    "/api/auth/**",
	                    "/api/appointments/**").permitAll()
	            .anyRequest().authenticated()
	        )
	        .httpBasic(httpBasic -> {});

	    return http.build();
	}
	}

