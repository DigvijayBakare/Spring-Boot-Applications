package com.jwt.services;

import com.jwt.model.CustomUserDetails;
import com.jwt.model.User;
import com.jwt.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailServices implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       /* if (username.equals("Digvijay")){
            return new User("Digvijay", "digvijay123", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found!!");
        }*/
        User user = this.userRepository.findByUserName(username);
        if (user==null) {
            throw new UsernameNotFoundException("User not found!!");
        } else {
            return new CustomUserDetails(user);
        }
    }
}
