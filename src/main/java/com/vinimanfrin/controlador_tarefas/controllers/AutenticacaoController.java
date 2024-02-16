package com.vinimanfrin.controlador_tarefas.controllers;

import com.vinimanfrin.controlador_tarefas.domain.user.LoginDTO;
import com.vinimanfrin.controlador_tarefas.domain.user.User;
import com.vinimanfrin.controlador_tarefas.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO dados){

        var dadosAutenticacaoSpring = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var autenticacao = manager.authenticate(dadosAutenticacaoSpring);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity registro(@RequestBody @Valid LoginDTO dados){
        if (userRepository.findByLogin(dados.login()) != null) return ResponseEntity.badRequest().build();

        String senhaCriptografada = new BCryptPasswordEncoder().encode(dados.senha());
        User newUser = new User(dados.login(), senhaCriptografada);

        userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
