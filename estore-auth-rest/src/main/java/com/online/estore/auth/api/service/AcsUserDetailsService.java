package com.online.estore.auth.api.service;

import com.online.estore.core.entity.User;
import com.online.estore.core.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

@Service("userDetailsService")
public class AcsUserDetailsService implements UserDetailsService {
    @Inject
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDetails = userRepository.findByUsername(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException(username);
        }
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        // for (SecurityRule role : userEntity.getRoles()) {
        authorities.add(new SimpleGrantedAuthority(userDetails.getRole()));
        // }
        return new org.springframework.security.core.userdetails.User(username, userDetails.getPassword(), true, true, true, true, authorities);
    }
}
