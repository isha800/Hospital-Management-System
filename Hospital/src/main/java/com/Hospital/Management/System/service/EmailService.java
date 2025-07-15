package com.Hospital.Management.System.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.Hospital.Management.System.dto.ForgotPasswordRequest;
import com.Hospital.Management.System.entity.User;
import com.Hospital.Management.System.repository.UserRepository;
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender; 

    @Autowired
    private UserRepository userRepository;

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
