package com.Hospital.Management.System.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Hospital.Management.System.dto.ForgotPasswordRequest;
import com.Hospital.Management.System.dto.LoginRequest;
import com.Hospital.Management.System.dto.RegisterRequest;
import com.Hospital.Management.System.entity.User;
import com.Hospital.Management.System.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	 @Autowired
	    private AuthService authService;

	  @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
	        if (authService.emailExists(request.getEmail())) {
	            return ResponseEntity.status(HttpStatus.CONFLICT)
	                                 .body("Email already exists");
	        }

	        authService.register(request);
	        return ResponseEntity.ok("User registered successfully");
	    }

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
	        try {
	            User user = authService.login(request);
	            Map<String, String> response = new HashMap<>();
	            response.put("token", "dummy-token-123");
	            response.put("email", user.getEmail());
	            response.put("name", user.getName());
	            return ResponseEntity.ok(user);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                                 .body(e.getMessage());
	        }
	    }

	    @PostMapping("/forgot-password")
	    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
	        try {
	            authService.forgotPassword(request);
	            return ResponseEntity.ok("Reset link sent to email");
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	}
