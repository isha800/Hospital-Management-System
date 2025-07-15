package com.Hospital.Management.System.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Hospital.Management.System.dto.ForgotPasswordRequest;
import com.Hospital.Management.System.dto.LoginRequest;
import com.Hospital.Management.System.dto.RegisterRequest;
import com.Hospital.Management.System.entity.User;
import com.Hospital.Management.System.repository.UserRepository;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class AuthService {
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private JavaMailSender mailSender;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public boolean emailExists(String email) {
	        return userRepository.findByEmail(email).isPresent();
	    }

	    public void register(RegisterRequest request) {
	        User user = new User();
	        user.setName(request.getName());
	        user.setEmail(request.getEmail());
	        user.setPassword(passwordEncoder.encode(request.getPassword()));
	        user.setRole("admin");
	        userRepository.save(user);
	    }

	    public User login(LoginRequest request) {
	        User user = userRepository.findByEmail(request.getEmail())
	                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

	        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
	            throw new RuntimeException("Invalid email or password");
	        }

	        return user;
	    }

	    public void forgotPassword(ForgotPasswordRequest request) {
	        User user = userRepository.findByEmail(request.getEmail())
	                .orElseThrow(() -> new RuntimeException("Email not found"));

	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(user.getEmail());
	        message.setSubject("Reset Your Password");
	        message.setText("Click the link to reset your password: http://localhost:4200/reset-password");

	        mailSender.send(message);
	    }
	}

