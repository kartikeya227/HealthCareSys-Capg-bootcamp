package com.cg.bootcamp.healthcare.service;

import com.cg.bootcamp.healthcare.dao.UserRepository;
import com.cg.bootcamp.healthcare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getUserRole());
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(authority);
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    authorities);
        } catch (Exception e) {
        }
        return null;
    }

    public User save(User user) {
        try {
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setFullName(user.getFullName());
            newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
            newUser.setUserRole(user.getUserRole());
            newUser.setContactNumber(user.getContactNumber());
            newUser.setEmailId(user.getEmailId());
            newUser.setUserAge(user.getUserAge());
            newUser.setUserGender(user.getUserGender());
            return userRepository.save(newUser);
        } catch (Exception e) {
            return null;
        }
    }
}
