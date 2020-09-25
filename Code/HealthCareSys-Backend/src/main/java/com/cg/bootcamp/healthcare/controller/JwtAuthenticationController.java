package com.cg.bootcamp.healthcare.controller;


import com.cg.bootcamp.healthcare.jwtconfig.JwtTokenUtil;
import com.cg.bootcamp.healthcare.model.JwtRequest;
import com.cg.bootcamp.healthcare.model.JwtResponse;
import com.cg.bootcamp.healthcare.model.User;
import com.cg.bootcamp.healthcare.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    /**
     * Http Requests with "/authenticate" and "/register" does not require JWT token in their header
     * these two requests are permited exclusively by WebSecurityConfigurerAdapter of SPRING BOOT.
     */

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    /**
     * Http Method : POST
     * Authenticate a user on the basis of username and password entered
     * Takes username and password as a JSON object in HTTP request body.
     * IF username found in database and also password is correct it returns a
     * JWT token which is needed to validate all other HTTP requests
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    /**
     * Http Method : POST
     * Registers a User, with all the data about the user
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
