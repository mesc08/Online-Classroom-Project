package com.online.classroom.config;


import com.online.classroom.security.JwtAuthenticationEntryPoint;
import com.online.classroom.security.JwtAuthenticationFilter;
import com.online.classroom.service.implementation.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
public class MySecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtAuthenticationEntryPoint point;

    @Autowired
    private JwtAuthenticationFilter filter;

//    @Bean
//    public UserDetailsService userDetailsService(){
//        //        UserDetails admin = User.withUsername("Basant")
////                .password(encoder.encode("Pwd1"))
////                .roles("ADMIN")
////                .build();
////        UserDetails user = User.withUsername("John")
////                .password(encoder.encode("Pwd2"))
////                .roles("USER","ADMIN","HR")
////                .build();
////        return new InMemoryUserDetailsManager(admin, user);
//        return new UserDetailsServiceImpl();
//    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            return http.csrf((csrf)-> csrf.disable())
                    .authorizeHttpRequests(auth -> auth.requestMatchers("/classroom/**").authenticated().requestMatchers("/auth/login").permitAll().requestMatchers("/auth/create-user").permitAll().anyRequest().authenticated())
                    .exceptionHandling(exception -> exception.authenticationEntryPoint(point))
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                    .build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }


}
