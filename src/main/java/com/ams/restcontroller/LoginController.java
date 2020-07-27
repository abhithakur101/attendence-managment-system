package com.ams.restcontroller;


import com.ams.modal.Employee;

import com.ams.repository.UserRepository;
import com.ams.response.AuthenticationResponse;
import com.ams.service.MyUserDetailsService;
import com.ams.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@ModelAttribute Employee employee) throws Exception {

        String empMobile = employee.getEmpMobile();
        String password = employee.getEmpPassword();
        Employee employee1 = userRepository.findByEmpMobile(empMobile);
        try {


            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(empMobile, password)
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(employee.getEmpMobile());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, employee1));
    }
}
