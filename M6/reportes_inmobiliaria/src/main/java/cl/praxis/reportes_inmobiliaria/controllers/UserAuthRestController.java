package cl.praxis.reportes_inmobiliaria.controllers;

import cl.praxis.reportes_inmobiliaria.entities.UserEntity;
import cl.praxis.reportes_inmobiliaria.security.jwt.JwtToken;
import cl.praxis.reportes_inmobiliaria.services.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserAuthRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtToken jwtToken;

    @PostMapping("/login")
    public String createToken(@RequestBody UserEntity userEntity) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userEntity.getEmail(), userEntity.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userEntity.getEmail());
        return jwtToken.generateToken(userDetails);
    }
}