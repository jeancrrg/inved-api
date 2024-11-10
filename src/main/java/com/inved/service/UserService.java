package com.inved.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//public class UserService {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenService jwtTokenService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private SecurityConfig securityConfiguration;
//
//    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());
//        Authentication authentication = authenticationManager.authenticate(authenticationToken);
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
//    }
//
//    // Método responsável por criar um usuário
//    public void createUser(CreateUserDto createUserDto) {
//        User newUser = new User(
//                createUserDto.email(),
//                securityConfiguration.passwordEncoder().encode(createUserDto.password()),
//                List.of(new Role(null, createUserDto.role()))
//        );
//
//        // Salva o novo usuário no banco de dados
//        userRepository.save(newUser);
//    }
//}
