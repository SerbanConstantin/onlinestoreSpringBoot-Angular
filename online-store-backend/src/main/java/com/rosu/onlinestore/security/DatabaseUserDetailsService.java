package com.rosu.onlinestore.security;

import com.rosu.onlinestore.model.User;
import com.rosu.onlinestore.repository.UserRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

import static org.springframework.security.core.userdetails.User.withUsername;

@Component
@Getter
@Slf4j
public class DatabaseUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;


    @Autowired
    public DatabaseUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Username " + username);



        User user = userRepository.findByEmail(username);

        return new CustomUserDetails(user);
    }

    public Optional<UserDetails> loadUserByJwtToken(String jwtToken) {

        if(jwtProvider.isTokenValid(jwtToken)) {
            return Optional.of(
                    withUsername(jwtProvider.getUsername(jwtToken))
                    .password("") // password should not be empty
                    .authorities(new ArrayList<>())
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build());
        }
        return Optional.empty();
    }
}
