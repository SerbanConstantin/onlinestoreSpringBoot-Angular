package com.rosu.onlinestore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public static class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
        private DatabaseUserDetailsService databaseUserDetailsService;

        @Autowired
        protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(databaseUserDetailsService).passwordEncoder(restPasswordEncoder());
        }
        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/**")
                    .cors() //cross origin request site
                    .and()
                    .csrf()
                    .disable()
                    .authorizeRequests()
                    //do not allow anything else
                    .antMatchers("/api/login").permitAll()
                    .anyRequest().authenticated();

            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.addFilterBefore(new UsernameAndPasswordAuthenticationFilter(databaseUserDetailsService),
                    UsernameAndPasswordAuthenticationFilter.class);


        }

        @Bean
        public PasswordEncoder restPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

    }

}
