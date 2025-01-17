package com.example.jwtpracticeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwtpracticeapp.models.MyUserDetails;
import com.example.jwtpracticeapp.models.User;
import com.example.jwtpracticeapp.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepo.findByUsername(username);
        if(user == null){
            System.out.println("User NOT Found.");
            throw new UsernameNotFoundException("User not Found");
        }
        return new MyUserDetails(user);
    }

}
