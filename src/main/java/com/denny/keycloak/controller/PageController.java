package com.denny.keycloak.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/page")
public class PageController {

    private JwtAuthenticationToken token;

    @GetMapping("/admin")
    public ResponseEntity<String> adminPage(Principal principal) {
        token = (JwtAuthenticationToken) principal;
        return ResponseEntity.ok(
                "Hello Administrator \nUser Name : "
                + token.getTokenAttributes().get("name")
                + "\nUser Email : "
                + token.getTokenAttributes().get("email")
        );
    }

    @GetMapping("/user")
    public ResponseEntity<String> userPage(Principal principal) {
        token = (JwtAuthenticationToken) principal;
        return ResponseEntity.ok(
                "Hello User \nUser Name : "
                        + token.getTokenAttributes().get("name")
                        + "\nUser Email : "
                        + token.getTokenAttributes().get("email")
        );
    }

    @GetMapping("/anonymous")
    public ResponseEntity<String> anonymousPage() {
        return ResponseEntity.ok("Hello Anonymous");
    }
}
