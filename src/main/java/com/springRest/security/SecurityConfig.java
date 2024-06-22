package com.springRest.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource; // Подключение к вашей базе данных

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, true FROM users WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, role FROM users WHERE username=?")
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").authenticated() // Доступ только авторизованным пользователям для /Home/**
                .anyRequest().permitAll() // Все остальные запросы разрешены
                .and()
                .formLogin()
                .loginPage("/login") // Страница входа
                .failureUrl("/login?error=true") // URL для обработки неудачного входа
                .defaultSuccessUrl("/Home/home-page", true) // URL после успешного входа
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout") // URL для выхода
                .logoutSuccessUrl("/login?logout=true") // URL после успешного выхода
                .permitAll()
                .and()
                .csrf().disable(); // Отключение CSRF для упрощения
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
