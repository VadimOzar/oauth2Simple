package com.dmv.service;

import com.dmv.domain.CustomUserDetails;
import com.dmv.domain.Role;
import com.dmv.domain.User;
import com.dmv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @PostConstruct
    public void createTestUser() {
        userRepository.save(new User("user", "user", Arrays.asList(new Role("USER"))));
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUserDetails(userRepository.findOneByUsername(username));
    }
}
