package com.gretacvld.climb_jam_api.helpers;

import com.gretacvld.climb_jam_api.entities.User;
import com.gretacvld.climb_jam_api.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.gretacvld.climb_jam_api.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    @Autowired
    private UserRepository userRepository;


    public User getCurrentUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
         return userRepository.findByEmail(username)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur introuvable"));
    }
}
