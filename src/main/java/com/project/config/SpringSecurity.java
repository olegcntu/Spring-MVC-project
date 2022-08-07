package com.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    //конфигурация по умолчанию гарантирует, что любой запрос к приложению
    // будет аутентифицирован с помощью входа в систему на основе формы или базовой аутентификации HTTP.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/workPage/add").access("hasRole('ROLE_USER')")
                .and()
                .formLogin()//Настроить страницу входа
                .loginPage("/enter")//Путь доступа к странице входа
               // .loginProcessingUrl("/login.do")//Путь к отправке формы на странице входа
                .failureUrl("/workPage/mainPage")//Путь для перехода после неудачного входа в систему
                .defaultSuccessUrl("/workPage/mainPage");//Путь перехода по умолчанию после успешного входа в систему
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("1")
                .password(passwordEncoder().encode("1")).roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }// Метод шифрования пароля
}
