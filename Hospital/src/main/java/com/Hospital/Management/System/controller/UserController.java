package com.Hospital.Management.System.controller;
import com.Hospital.Management.System.dto.UpdateProfileRequest;
import com.Hospital.Management.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	    @Autowired private UserService userService;
	    @GetMapping("/me")
	    public ResponseEntity<?> getProfile(@RequestParam String email) {
	        return ResponseEntity.ok(userService.getProfile(email));
	    }

	    @PutMapping("/update")
	    public ResponseEntity<?> updateProfile(@RequestBody UpdateProfileRequest request) {
	        return ResponseEntity.ok(userService.updateProfile(request.getEmail(), request));
	    }
	}
