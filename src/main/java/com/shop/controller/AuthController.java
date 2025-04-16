package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.javapoet.ClassName;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.AuthRequest;
import com.shop.dto.JwtResponse;
import com.shop.model.User;
import com.shop.repository.UserRepository;
import com.shop.util.AppMessages;
import com.shop.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(ClassName.class);
	
	@Autowired	private AuthenticationManager authenticationManager;
	@Autowired	private UserDetailsService userDetailsService;
	@Autowired	private JwtUtil jwtUtil;
	@Autowired	private UserRepository userRepository;
	@Autowired	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public String register(@RequestBody AuthRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole("USER");
		userRepository.save(user);
		return AppMessages.USER_REGISTRATION_SUCESSFULL;
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthRequest request) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails.getUsername());
		return ResponseEntity.ok(new JwtResponse(jwt));
	}
}
