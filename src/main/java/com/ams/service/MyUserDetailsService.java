package com.ams.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface MyUserDetailsService extends UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s);
}
