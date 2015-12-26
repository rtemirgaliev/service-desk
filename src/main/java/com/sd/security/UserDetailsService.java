package com.sd.security;


import com.sd.domain.User;
import com.sd.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Inject
    private UserRepository userRepository;



    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        log.info("Authenticating {}", login);
        String lowerCaseLogin = login.toLowerCase();
        Optional<User> userFromDatabase = userRepository.findOneByLogin(lowerCaseLogin);
        log.info("userFromDatabase: " + userFromDatabase.toString());


        return userFromDatabase.map(user -> {
            if(!user.getActivated()) {
                throw new UserNotActivatedException("User " + lowerCaseLogin + " was not activated");
            }
            List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                    .collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(lowerCaseLogin, user.getPassword(), grantedAuthorities);

        }).orElseThrow(() -> new UsernameNotFoundException("User " + lowerCaseLogin + " was not found in the " + "database"));

    }
}
