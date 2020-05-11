package com.infy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.dto.AuthRequest;
import com.infy.dto.AuthResponse;
import com.infy.security.JwtUtil;
import com.infy.service.CustomerDetailsService;

@RestController
public class CustomerAuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@Autowired
	private JwtUtil jwtUtilToken;
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken
		(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken
						(authRequest.getEmail(), authRequest.getPassword())
				);
			} catch(BadCredentialsException e) {
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
			}
		
		final UserDetails userDetails = customerDetailsService
				.loadUserByUsername(authRequest.getEmail());
		final String jwt = jwtUtilToken.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(jwt));
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("hello");
		return "Helo World!";
	}
}
