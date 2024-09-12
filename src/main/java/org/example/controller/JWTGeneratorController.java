package org.example.controller;

import org.example.service.JWTGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JWTGeneratorController {
    @GetMapping("/")
    public String home(@RequestParam(required = false) String nickName, @RequestParam(required = false) String password, @RequestParam(required = false) String email) {
        if (nickName == null || password == null || email == null) {
            return "please try again with params (nickname, password, email)";
        }
        JWTGenerator JWTGen = new JWTGenerator();
        Map<String, String> claims = new HashMap<>();
        claims.put("nickName", nickName);
        claims.put("password", password);
        claims.put("email", email);
        String token = JWTGen.createJWT(claims);
        System.out.printf("%s\n", nickName);
        System.out.printf(password);
        System.out.printf(email);

        return token;
    }

    @RequestMapping("/")
    public String home() {
        return "a";
    }
}
