package com.online.estore.auth.api.controller;

import com.online.estore.auth.api.model.AuthenticationRequest;
import com.online.estore.auth.api.model.AuthenticationResponse;
import com.online.estore.auth.api.utils.JwtUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/api/v1")
public class AcsController {
    @Inject
    private AuthenticationManager authenticationManager;
    @Inject
    private UserDetailsService acsUserDetailsService;

    @PostMapping(path = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new UsernameNotFoundException("Username or password not valid");
        }
        //fetch user details
        UserDetails userDetails = acsUserDetailsService.loadUserByUsername(request.getUsername());
        //generate Jwt
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(JwtUtils.generateToken(userDetails));
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/secure", produces = "application/json")
    @ResponseBody
    @Secured("hasRole('ROLE_USER')")
    public ResponseEntity<String> secureAccess() {
        return ResponseEntity.ok("Secure access permitted!!!");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("ACS API server up!!!");
    }
}
